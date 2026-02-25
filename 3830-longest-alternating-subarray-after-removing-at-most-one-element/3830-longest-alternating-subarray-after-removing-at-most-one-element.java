class Solution {
    int[] nums;
    int n;
    Integer[][][] dp;
    public int longestAlternating(int[] nums) {
        this.nums=nums;
        this.n=nums.length;

        dp=new Integer[n][3][2];//prevSign ind = -1 -> 0, 0 -> 1, 1 -> 2;
        int ans=1;

        for(int i=0;i<n;i++){
            ans=Math.max(ans, solve(i, 0, 0));
        }

        return ans;
    }

    public int solve(int idx, int prevSign, int used){
        if(idx>=n-1) return 1;

        int prevSignInd=prevSign+1;// map -1,0,1 → 0,1,2

        if(dp[idx][prevSignInd][used]!=null) return dp[idx][prevSignInd][used];

        int ans=1;
        int sign=compare(nums[idx], nums[idx+1]);

        //option 1 -> normal continuation alternating signs
        if(sign!=0 && (prevSign==0 || prevSign!=sign)){
            ans=Math.max(ans, 1+solve(idx+1, sign, used));
        }

        //option 2 -> deletion
        if(used==0 && idx+2<n){
            int newSign=compare(nums[idx], nums[idx+2]);

            if(newSign!=0 && (prevSign==0 || prevSign!=newSign)){
                ans=Math.max(ans, 1+solve(idx+2, newSign, 1));
            }
        }
        
        dp[idx][prevSignInd][used]=ans;
        return ans;
    }

    public int compare(int a, int b){
        if(a>b) return -1;
        if(a<b) return 1;
        return 0;
    }
}