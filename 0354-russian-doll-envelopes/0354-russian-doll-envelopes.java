
/*class Solution {
    
    public int maxEnvelopes(int[][] envelopes) {
        int n=envelopes.length;
        if(n==0)return 0;

        Arrays.sort(envelopes, (a,b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int max_envelope=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(envelopes[i][0]>envelopes[j][0] && envelopes[j][1]<envelopes[i][1]){
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            max_envelope=Math.max(dp[i], max_envelope);
        }
        return max_envelope;
    }   
    
    }
    
     AS THIS CODE GIVE ERROR FOR LAST 2 TESTCASES HERE IS THE NEW BINARY SEARCH CODE*/


     class Solution {
    public int maxEnvelopes(int[][] arr) {
         int n = arr.length;
        Arrays.sort(arr,(p,q)-> p[0]==q[0] ? q[1]-p[1] : p[0]-q[0]);
        
         int dp[] = new int[arr.length];
    int len = 0;
    for(int[] envelope : arr){
        int index = binarySearch(dp, 0, len, envelope[1]);
        
        dp[index] = envelope[1];
        if(index == len)
            len++;
    }
    return len;
        
    }
    
    public int binarySearch(int[] dp,int si, int ei, int target) {
         while(si<ei){
             int mid = si+(ei-si)/2;
             if(dp[mid] == target) return mid;
             else if(dp[mid] > target) ei = mid;
             else  si = mid+1;
         }
        return si;
    }
}



