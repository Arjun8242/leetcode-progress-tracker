class Solution {
    public int findNumbers(int[] nums) {
        int even_count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int dig=countdigits(nums[i]);
            if(dig%2==0){
                even_count++;
            }
        }
        return even_count;
    }
    public static int countdigits(int nums_of_i){
        int count=0;
        while(nums_of_i>0){
            nums_of_i=nums_of_i/10;
            count++;
        }
        return count;
    }
}