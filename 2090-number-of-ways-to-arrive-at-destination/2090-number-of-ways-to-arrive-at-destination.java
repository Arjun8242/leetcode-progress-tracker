class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] road: roads){
            int u=road[0], v=road[1], t=road[2];
            graph.get(u).add(new int[]{v,t});
            graph.get(v).add(new int[]{u,t});
        }

        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;

        long[] ways=new long[n];
        Arrays.fill(ways, 0);
        ways[0]=1;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b) -> Long.compare(a[0], b[0]));
        pq.add(new long[]{0L, 0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            long d=curr[0];
            int u=(int)curr[1];
            for(int[] edge:graph.get(u)){
                int v=edge[0];
                long w=edge[1];
                 if(d>dist[u]) continue;
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    ways[v]=ways[u];
                    pq.add(new long[]{dist[v], v});
                }
                else if(dist[v]==dist[u]+w){
                    ways[v]=(ways[v]+ways[u])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
}