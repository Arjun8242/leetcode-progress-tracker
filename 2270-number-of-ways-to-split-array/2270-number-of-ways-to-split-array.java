class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long[] sumleft=new long[n];
        long[] sumright=new long[n];

        sumleft[0]=nums[0];
        for(int i=1;i<n;i++){
            sumleft[i]=sumleft[i-1]+nums[i];
        }

        sumright[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            sumright[i]=sumright[i+1]+nums[i];
        }

        int count=0;
        for(int i=1;i<n;i++){
            if(sumleft[i-1]>=sumright[i]) count++;
        }
        return count;
    }
}