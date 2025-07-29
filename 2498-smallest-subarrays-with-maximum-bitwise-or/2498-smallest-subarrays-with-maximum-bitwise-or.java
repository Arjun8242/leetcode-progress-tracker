class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[] lastseen=new int[32];
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){
            for(int bit=0;bit<32;bit++){
                if(((nums[i]>>bit) & 1) == 1){
                    lastseen[bit]=i;
                }
            }

            int maxindex=i;

            for(int bit=0;bit<32;bit++){
                maxindex=Math.max(maxindex,lastseen[bit]);
            }

            ans[i]=maxindex-i+1;
        }

        return ans;
    }
}