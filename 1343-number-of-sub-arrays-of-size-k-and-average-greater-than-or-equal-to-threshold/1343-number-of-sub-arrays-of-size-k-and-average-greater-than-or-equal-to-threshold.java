class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n=arr.length;
        int left=0;
        int ans=0;

        int sum=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];

            if(right>=k-1){
                if(sum/k>=threshold){
                    ans++;
                }
                sum-=arr[left];
                left++;
            }
        }
        return ans;
    }
}