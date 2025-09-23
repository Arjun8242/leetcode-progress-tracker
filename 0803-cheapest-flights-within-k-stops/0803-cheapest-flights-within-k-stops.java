class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] f:flights){
            int u=f[0];
            int v=f[1];
            int w=f[2];
            graph.get(u).add(new int[]{v, w});
        }

        Queue<int[]> queue=new LinkedList<>();
        int[] costs=new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src]=0;
        queue.add(new int[]{src, 0, 0});

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int node=curr[0], cost=curr[1], stop=curr[2];

            if(stop>k) continue;

            for(int[] nei:graph.get(node)){
                int next=nei[0];
                int price=nei[1];

                int newcost=price+cost;

                if(newcost<costs[next]){
                    costs[next]=newcost;
                    queue.add(new int[]{next, newcost, stop+1});
                }
            }
        }
        return costs[dst]==Integer.MAX_VALUE? -1 : costs[dst];
    }
}