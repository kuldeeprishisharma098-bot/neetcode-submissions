class WordDictionary {

    // Define the internal Trie Node structure
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // 26 letters in English alphabet
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // O(N) Time Complexity - N is the length of the word
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    // Launches DFS starting from the root at character index 0
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // O(N) Time Complexity due to the max constraint of 2 dots
    private boolean dfs(String word, int index, TrieNode curr) {
        // Base Case: Reached the end of the word string
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard match: Try all possible 26 alphabet paths
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    if (dfs(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
            return false; // None of the branches formed a valid match
        } else {
            // Normal character match
            int childIndex = ch - 'a';
            if (curr.children[childIndex] == null) {
                return false;
            }
            return dfs(word, index + 1, curr.children[childIndex]);
        }
    }
}
