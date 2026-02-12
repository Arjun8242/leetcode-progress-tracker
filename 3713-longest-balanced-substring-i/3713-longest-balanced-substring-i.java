class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int max = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[ch[j] - 'a']++;
                if (balanced(freq)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    public boolean balanced(int[] freq){
        int i = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (i == 0)i = f;
            else if (f != i) return false;
        }
        return true;
    }
}