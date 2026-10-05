class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int maxLength = 0;
        int l = 0;
        boolean[] seen = new boolean[128];
        for(int r = 0; r < n; r++){
            char currChar = s.charAt(r);
            while(seen[currChar]){
                seen[s.charAt(l)] = false; // Fixed: changed '1' to 'l'
                l++;
            }
            seen[currChar] = true;
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
