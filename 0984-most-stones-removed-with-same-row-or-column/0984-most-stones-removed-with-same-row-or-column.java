class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        boolean[] vis = new boolean[n];
        int components=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, stones, vis);
                components++;
            }
        }
        return n-components;
    }
    public void dfs(int i, int[][] stones, boolean[] vis){
        vis[i]=true;
        for(int j=0;j<stones.length;j++){
            if((stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]) && !vis[j]){
                dfs(j, stones, vis);
            }
        }
    }
}