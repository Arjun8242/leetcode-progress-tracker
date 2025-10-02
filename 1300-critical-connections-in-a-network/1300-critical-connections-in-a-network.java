class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> conn: connections){
            int u=conn.get(0);
            int v=conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] discovery=new int[n];
        int[] low=new int[n];
        Arrays.fill(discovery, -1);
        List<List<Integer>> ans=new ArrayList<>();

        dfs(graph, discovery, low, ans, 0, -1, 0);
        return ans;
    }
    public void dfs(List<List<Integer>> graph, int[] discovery, int[] low, List<List<Integer>> ans, int u, int parent, int time){
        discovery[u]=low[u]=time++;
        for(int v: graph.get(u)){
            if(v==parent) continue;
            if(discovery[v]==-1){
                dfs(graph, discovery, low, ans, v, u, time);
                low[u]=Math.min(low[u], low[v]);
                if(low[v]>discovery[u]) ans.add(Arrays.asList(u, v));
            }
             else low[u]=Math.min(low[u], discovery[v]);
        }
    }
}