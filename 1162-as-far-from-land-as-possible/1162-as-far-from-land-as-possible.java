class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<int[]> queue=new LinkedList<>();
        int dist=0;
        int[][] dirs={{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if(queue.size()==0 || queue.size()==n*n) return -1;

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int s=0;s<size;s++){
                int[] cell=queue.poll();
                int row=cell[0];
                int col=cell[1];

                for(int[] d:dirs){
                    int nrow=row+d[0];
                    int ncol=col+d[1];
                    if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && grid[nrow][ncol]==0){
                        grid[nrow][ncol]=1;
                        queue.offer(new int[]{nrow, ncol});
                    }
                }
            }
            dist++;
        }
        return dist-1;

    }
}