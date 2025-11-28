class Solution {
    public void sortColors(int[] nums) {
        int travel=0;
        int low=0;
        int high=nums.length-1;

        while(travel<=high){
            if(nums[travel]==0){
                int swap=nums[travel];
                nums[travel]=nums[low];
                nums[low]=swap;
                travel++;
                low++;
            }
            else if(nums[travel]==2){
                int swap=nums[travel];
                nums[travel]=nums[high];
                nums[high]=swap;
                high--;
            }
            else{
                travel++;
            }
        }
    }
}