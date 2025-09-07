class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[126];
        int n=s.length();
        int start=0, left=0, minlen=Integer.MAX_VALUE, need=t.length();
        for(char c:t.toCharArray()){
            freq[c]++;
        }
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(freq[ch]>0){
                need--;
            }
            freq[ch]--;

            while(need==0){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }

                char c=s.charAt(left);
                freq[c]++;
                if(freq[c]>0){
                    need++;
                }
                left++;
            }
        }
            return minlen==Integer.MAX_VALUE? "":s.substring(start, start+minlen);
    }
}