class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int[] ans=new int[2];
        ans[0]=findfirst(nums, target);
        ans[1]=findlast(nums, target);

        return ans;
    }
    public int findfirst(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int mid=0;
        int res=-1;


        while(low<=high){
            mid=(low+high)/2;
            
            if(nums[mid]==target){
                res=mid;
                high=mid-1;
            }
            else if(nums[mid]>target) high=mid-1;

            else low=mid+1;
        }

        return res;
    }

    public int findlast(int[] nums, int target){
        int low=0;
        int high=nums.length-1;
        int mid=0;
        int res=-1;


        while(low<=high){
            mid=(low+high)/2;
            
            if(nums[mid]==target){
                res=mid;
                low=mid+1;
            }
            else if(nums[mid]>target) high=mid-1;

            else low=mid+1;
        }

        return res;
    }
}