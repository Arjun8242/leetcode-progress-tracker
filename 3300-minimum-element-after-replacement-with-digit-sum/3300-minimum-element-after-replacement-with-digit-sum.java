class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            nums[i]=sum(nums[i]);
            min=Math.min(min, nums[i]);
        }
        return min;
    }
    public int sum(int x){
        int sum=0;
        while(x>0){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }
}