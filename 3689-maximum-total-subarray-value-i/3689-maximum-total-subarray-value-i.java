class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(num, min);
            max=Math.max(max, num);
        }
        long ans=(long)max-min;
        long res=ans*k;
        return res;
    }
}