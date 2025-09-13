class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!dfs(graph, color, i, 1)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int[][] graph, int[] color, int node, int col){
        if(color[node]!=0){
            return color[node]==col;
        }

        color[node]=col;
        
        int[] neighbor=graph[node];
        for(int nei:neighbor){
            if(!dfs(graph, color, nei, -col)){
                return false;
            }
        }
        return true;
    }
}