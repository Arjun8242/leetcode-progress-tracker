class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] vis=new boolean[n];
        int provinces=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                if(dfs(isConnected, vis, i)){
                    provinces++;
                }
            }
        }
        return provinces;
    }
    public boolean dfs(int[][] isConnected, boolean[] vis, int city){
        vis[city]=true;

        for(int i=0;i<isConnected.length;i++){
            if(!vis[i] && isConnected[i][city]==1){
                if(!dfs(isConnected, vis, i)){
                    return false;
                }
            }
        }
        return true;
    }
}