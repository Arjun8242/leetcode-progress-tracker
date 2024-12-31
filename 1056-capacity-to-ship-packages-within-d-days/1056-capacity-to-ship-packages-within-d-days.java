class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxweight=-1;
        int totalweights=0;
        for(int i=0;i<weights.length;i++){
            maxweight=Math.max(maxweight, weights[i]);
            totalweights=totalweights+weights[i];
        }
        int low=maxweight;
        int high=totalweights;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int numberofdays=capacity(weights, mid);
            if(numberofdays<=days){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    
    int capacity(int[] weights, int cap){
        int n=weights.length;
        int loads=0;int days=1;
        for(int i=0;i<n;i++){
            if(loads+weights[i]>cap){
                days=days+1;
                loads=weights[i];
            }
            else{
                loads=loads+weights[i];
            }
        }
        return days;
    }
}