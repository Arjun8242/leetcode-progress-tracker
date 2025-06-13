class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int low=0;
        int high=nums[nums.length-1]-nums[0];
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(pairs(nums,mid,p)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean pairs(int[] nums, int mid, int p){
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<=mid){
            count++;
            i++;
            }
        }
        return count>=p;
    }
}