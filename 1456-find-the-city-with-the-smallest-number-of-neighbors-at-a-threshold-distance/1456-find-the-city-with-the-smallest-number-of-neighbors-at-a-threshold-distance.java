class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e:edges){
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int mincount=Integer.MAX_VALUE, resultcity=-1;
        for(int start=0;start<n;start++){
            int[] dist=new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start]=0;

            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
            pq.add(new int[]{start, 0});

            while(!pq.isEmpty()){
                int[] curr=pq.poll();
                int city=curr[0];
                int distance=curr[1];

                if(distance>distanceThreshold) continue;

                for(int[] nei: graph.get(city)){
                    int ndistance=distance+nei[1];
                    if(ndistance<dist[nei[0]]){
                        dist[nei[0]]=ndistance;
                        pq.add(new int[]{nei[0], ndistance});
                    }
                }
            }
            int count=0;
            for(int i=0;i<n;i++){
                if(i!=start && dist[i]<=distanceThreshold) count++;
            }
            if(count<=mincount){
                mincount=count;
                resultcity=start;
            }
        }
        return resultcity;
    }
}