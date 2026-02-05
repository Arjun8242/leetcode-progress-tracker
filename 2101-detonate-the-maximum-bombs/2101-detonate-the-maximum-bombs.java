class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            long x1=bombs[i][0];
            long y1=bombs[i][1];
            long r1=bombs[i][2];

            for(int j=0;j<n;j++){

                if(i==j) continue;
                long x2=bombs[j][0];
                long y2=bombs[j][1];
                long dx=x1-x2;
                long dy=y1-y2;

                //if x2,y2 bomb comes under area range of x1, y1 then denote bomb 2 as j and bomb 1 as i and make directed graph 
                if(dx*dx+dy*dy<=r1*r1){
                    graph.get(i).add(j);
                }
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            boolean[] vis=new boolean[bombs.length];//create visited array seperately to fins maximum coverage
            ans=Math.max(ans, dfs(graph, vis, i));
        }
        return ans;
    }

    public int dfs(List<List<Integer>> graph, boolean[] vis, int node){
        vis[node]=true;
        int count=1;//alone bomb is also bomb

        for(int i:graph.get(node)){
            if(!vis[i]){
                count+=dfs(graph, vis, i);
            }
        }
        return count;
    }
}