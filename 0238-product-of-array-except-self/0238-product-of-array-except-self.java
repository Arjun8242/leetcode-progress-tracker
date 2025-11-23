class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] productleft=new int[n];
        int[] productright=new int[n];

        productleft[0]=1;
        for(int i=1;i<n;i++){
            productleft[i]=productleft[i-1]*nums[i-1];
        }

        productright[n-1]=1;
        for(int i=n-2;i>=0;i--){
            productright[i]=productright[i+1]*nums[i+1];
        }

        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=productleft[i]*productright[i];
        }
        return ans;
    }
}