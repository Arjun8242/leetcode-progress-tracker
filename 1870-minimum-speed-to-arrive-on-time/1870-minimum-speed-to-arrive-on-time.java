class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int high=10000000;
        int low=1;
        int ans=-1;
        int mid=0;

        int n=dist.length;  

        while(low<=high){
            mid=(low+high)/2;
            double time=reqdTime(dist, mid);

            if(time<=hour){
                ans=mid;
                high=mid-1;
            }

            else{
                low=mid+1;
            }
        }

        return ans;
    }

    public double reqdTime(int[] dist, int speed){
        double time=0;
        int n=dist.length;

        for(int i=0;i<n-1;i++){
            time+=Math.ceil((double)dist[i]/speed);
        }
        time+=(double)dist[n-1]/speed;

        return time;
    }
}