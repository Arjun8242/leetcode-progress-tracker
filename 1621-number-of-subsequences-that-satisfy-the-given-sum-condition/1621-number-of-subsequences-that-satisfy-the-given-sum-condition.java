class Solution {
    int mod=1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] pow=new int[n];
        pow[0]=1;

        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }

        int ans=0;
        int left=0;
        int right=n-1;

        while(left<=right){
            if(nums[left]+nums[right]<=target){
                ans=(ans+pow[right-left])%mod;
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}