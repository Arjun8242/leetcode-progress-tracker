class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxfreq=Integer.MIN_VALUE;
        for(int i:map.values()){
            maxfreq=Math.max(maxfreq, i);
        }
        int count=0;
        for(int i:map.values()){
            if(i==maxfreq){
                count+=maxfreq;
            }
        }
        return count;
    }
}