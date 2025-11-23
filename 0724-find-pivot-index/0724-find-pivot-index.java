class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int[] sumleft=new int[n];
        sumleft[0]=nums[0];
        int[] sumright=new int[n];
        sumright[n-1]=nums[n-1];

        for(int i=1;i<n;i++){
            sumleft[i]=sumleft[i-1]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            sumright[i]=sumright[i+1]+nums[i];
        }

        for(int i=0;i<n;i++){
            if(sumleft[i]==sumright[i]){
                return i;
            }
        }
        return -1;
    }
}