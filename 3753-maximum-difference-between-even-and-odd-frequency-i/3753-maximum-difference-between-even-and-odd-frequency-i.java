class Solution {
    public int maxDifference(String s) {
        int[] letters=new int[26];
        for(char c:s.toCharArray()){
            letters[c-'a']++;
        }
        int maxodd=Integer.MIN_VALUE;
        int mineven=Integer.MAX_VALUE;
        for(int freq:letters){
            if(freq>0){
                if(freq%2==0){
                    if(freq<mineven){
                        mineven=freq;
                    }
                }
                else{
                    if(freq>maxodd){
                        maxodd=freq;
                    }
                }
            }
        }
        if(maxodd==Integer.MIN_VALUE || mineven==Integer.MAX_VALUE) return 0;
        return maxodd-mineven;
    }
}