class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];

        int counteven=0;
        int countodd=0;

        for(int i=n-1;i>=0;i--){
            if(nums[i]%2==0){
                ans[i]=countodd;
                counteven++;
            }
            else{
                ans[i]=counteven;
                countodd++;
            }
        }

        return ans;
    }
}