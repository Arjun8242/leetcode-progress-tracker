class Solution {
    public int partitionArray(int[] nums, int k) {
       Arrays.sort(nums);
       int count=1;
       /*int arr_min=nums[0];
       for(int i=0;i<nums.length;i++){
            if(nums[i]-arr_min<=k){
                continue;
            }
            else{
                count++;
                arr_min=nums[i];
            }
       }*/

       int i=0;
       int j=0;
       while(j<nums.length){
        if(nums[j]-nums[i]>k){
            i=j;
            count++;
        }
        j++;
       }

       return count;
    }
}