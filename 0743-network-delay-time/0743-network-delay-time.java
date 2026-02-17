class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist=new int[n+1];
        int ans=0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            graph.get(u).add(new int[]{v, w});
        }
        
        pq.add(new int[] {0, k});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int node=curr[1];

            for(int[] nei:graph.get(node)){
                int v=nei[0];
                int w=nei[1];
                if(dist[v]>dist[node]+w){
                    dist[v]=dist[node]+w;
                    pq.add(new int[]{node, v});
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans, dist[i]);
        }
        return ans;

    }
}