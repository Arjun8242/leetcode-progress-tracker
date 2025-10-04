class Solution {
    public int makeConnected(int n, int[][] connections) {

        if(connections.length < n-1) return -1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] conn : connections) {
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }
        boolean[] vis = new boolean[n+1];
        int components=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                components++;
            }
        }
        return components-1;
    }
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]){
                dfs(nei, adj, vis);
            }
        }
    }
}