class Solution {
    public int maxProduct(int[] nums) {
        int currmax=nums[0];
        int currmin=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            int x=nums[i];
            
            if(x<0){
                int temp=currmax;
                currmax=currmin;
                currmin=temp;
            }

            currmax=Math.max(x, currmax*x);
            currmin=Math.min(x, currmin*x);

            ans=Math.max(currmax, ans);
        }
        return ans;
    }
}