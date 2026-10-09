class PrefixTree {

    // Helper inner class for Trie nodes
    private static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    // Initializes the prefix tree object.
    public PrefixTree() {
        root = new TrieNode();
    }
    
    // Inserts the string word into the prefix tree.
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    // Returns true if the string word is in the prefix tree, and false otherwise.
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }
    
    // Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }
}
