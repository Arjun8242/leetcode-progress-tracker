class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();


        int[] freq1=new int[26];
        int[] freq2=new int[26];

        int left=0;

        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }

        for(int right=0;right<n2;right++){
            freq2[s2.charAt(right)-'a']++;

            if(right-left+1>n1){
                freq2[s2.charAt(left)-'a']--;
                left++;
            }

            if(right-left+1==n1){
                if(Arrays.equals(freq1, freq2)){
                    return true;
                }
            }
        }
        return false;
    }
}