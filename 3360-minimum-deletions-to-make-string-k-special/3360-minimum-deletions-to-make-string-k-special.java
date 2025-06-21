class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        List<Integer> frequency=new ArrayList<>();
        for(int i:freq){
            if(i>0)frequency.add(i);
        }

        Collections.sort(frequency);
        int n=frequency.size();
        int mindel=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int base=frequency.get(i);
            int del=0;

            for(int j=0;j<i;j++){
                del+=frequency.get(j);
            }
            for(int j=i+1;j<n;j++){
                if(frequency.get(j)>base+k){
                    del+=frequency.get(j)-(base+k);
                }
            }
            mindel=Math.min(mindel,del);
        }
        return mindel;
    }
}