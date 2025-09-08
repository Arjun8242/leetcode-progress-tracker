class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n+1];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected, vis, i);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int[][] connected, boolean[] vis, int city){
        vis[city]=true;
        for(int j=0;j<connected.length;j++){
            if(connected[city][j]==1 && !vis[j]){
                dfs(connected, vis, j);
            }
        }
    }
}