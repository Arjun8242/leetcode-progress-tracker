class Solution {
    String s;
    int encCost, flatCost;
    int[] prefix;
    public long minCost(String s, int encCost, int flatCost) {
        this.s=s;
        this.encCost=encCost;
        this.flatCost=flatCost;
        int n=s.length();
        prefix=new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+(s.charAt(i)=='1'?1:0);
        }

        return solve(0, n-1);
    }

    public long solve(int left, int right){
        int len=right-left+1;
        int ones=prefix[right+1]-prefix[left];
        long cost=0;

        if(ones==0){
            cost=flatCost;
        }
        else{
            cost=1L*len*ones*encCost;
        }

        if(len%2==0){
            int mid=(left+right)/2;
            cost=Math.min(cost, solve(left, mid)+solve(mid+1, right));
        }

        return cost;
    }
}