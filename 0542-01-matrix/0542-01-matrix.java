class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] dist=new int[m][n];
        boolean[][] vis=new boolean[m][n];
        int[][] dirs={{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int s=0;s<size;s++){
                int[] cell=queue.poll();
                int row=cell[0];
                int col=cell[1];
                for(int[] d:dirs){
                    int nrow=d[0]+row;
                    int ncol=d[1]+col;
                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && !vis[nrow][ncol]){
                        dist[nrow][ncol]=dist[row][col]+1;
                        vis[nrow][ncol]=true;
                        queue.offer(new int[]{ nrow, ncol});
                    }
                }
            }
        }
        return dist;
    }
}