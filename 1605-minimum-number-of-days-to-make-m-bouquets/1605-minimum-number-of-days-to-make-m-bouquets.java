class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }

        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            max=Math.max(bloomDay[i], max);
            min=Math.min(bloomDay[i],min);
        }

        int ans=0;
        int low=min;
        int high=max;
        while(low<=high){
            int mid=(low+high)/2;
            int bqts=possiblebqts(bloomDay,m,k,mid);
            if(bqts>=m){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
        
    }
   int possiblebqts(int[] bloomDay,int m,int k,int days){
        int tot=0; int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=days){
                count++;
                if(count>=k){
                    count=0;
                    tot++;
                }
            }
            else{count=0;}
            }
            return tot;
        }
    }