class Solution {
    public int splitArray(int[] nums, int k) {
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            max=Math.max(max,nums[i]);
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high){
           int mid=(low+high)/2;
            if(splitarray(nums,mid,k)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
           
        }
         return ans;
    }
    public static boolean splitarray(int[] nums, int mid, int k){
        int sum=0;
        int subarrays=1;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>mid){
                subarrays++;
                sum=nums[i];
            }
        }
        if(subarrays<=k){
            return true;
        }
        return false;
    }
    }
