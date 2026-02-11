class Solution {
    
    class DSU{
        int[] parent;
        int[] size;

        public DSU(int n){
            parent=new int[n+1];
            size=new int[n+1];

            for(int i=1;i<=n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }

        public int findParent(int node){
            if(parent[node]==node) return node;

            return parent[node]=findParent(parent[node]);
        }

    public boolean unionBySize(int u, int v){
        int pu=findParent(u);
        int pv=findParent(v);

        if(pv==pu) return false;

        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        
        return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DSU dsu=new DSU(n);

        int[] ans=new int[2];

        for(int[] nei:edges){
            if(!dsu.unionBySize(nei[0], nei[1])){
                ans=nei;
            }
        }
        return ans;
    }
}