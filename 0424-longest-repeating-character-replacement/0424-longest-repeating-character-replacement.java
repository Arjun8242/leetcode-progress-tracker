class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0,right=0,maxfreq=0;
        int result=0;
        int[] freq=new int[26];
        for(right=0;right<n;right++){
            freq[s.charAt(right)-'A']++;
            maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
            int windowlen=right-left+1;
            if(windowlen-maxfreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}