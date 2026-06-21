class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n=costs.length;
        int ans=0;

        for(int i=0;i<n;i++){
            if(costs[i]<=coins){
                ans++;
                coins-=costs[i];
            }
        }
        return ans;
    }
}