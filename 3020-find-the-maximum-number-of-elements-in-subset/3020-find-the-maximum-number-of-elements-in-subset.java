class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq=new HashMap<>();
        int ans=1;

        for(int num:nums){
            freq.put((long)num, freq.getOrDefault((long)num, 0) +1);
        }

        if(freq.containsKey(1L)){
            int ones=freq.get(1L);
            ans=(ones%2==0)?ones-1:ones;
        }
        for(long start:freq.keySet()){
            if(start==1) continue;

            int len=0;
            long curr=start;

            while(freq.getOrDefault(curr, 0)>=2){
                len+=2;
                curr=curr*curr;
            }

            if(freq.getOrDefault(curr, 0)==1){
                len++;
            }
            else{
                len--;
            }
            ans=Math.max(ans, len);
        }
        return ans;
    }
}