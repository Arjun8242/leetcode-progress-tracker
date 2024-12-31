class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sumbyd(nums,mid)<=threshold){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    int sumbyd(int[] nums, int div){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil(1.0*nums[i]/div);
        }
        return sum;
    }
}