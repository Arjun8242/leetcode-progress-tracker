class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> ans=new ArrayList<>();
        int[] state=new int[n];
        for(int i=0;i<n;i++){
            if(dfs(graph, i, state))
            ans.add(i);
        }
        return ans;
    }
    public boolean dfs(int[][] graph, int node, int[] state){
        if(state[node]!=0){
            return state[node]==2;
        }
        state[node]=1;
        int[] neighbor=graph[node];
        for(int nei:neighbor){
            if(!dfs(graph, nei, state)) return false;
        }
        state[node]=2;
        return true;
    }
}