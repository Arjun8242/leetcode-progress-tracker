class Solution {
    public int swimInWater(int[][] grid) {
        int row=grid.length;
        int col=grid.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int[][] dirs={{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][] dist=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        pq.add(new int[]{grid[0][0], 0, 0});

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int maxpath=curr[0];
            int x=curr[1];
            int y=curr[2];
            if(x==row-1 && y==col-1){
                return maxpath;
            }
            for(int[] d:dirs){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx<row && nx>=0 && ny<col && ny>=0){
                    int newmaxpath=Math.max(grid[nx][ny], maxpath);
                    if(newmaxpath<dist[nx][ny]){
                       dist[nx][ny]=newmaxpath;
                       pq.add(new int[] {newmaxpath, nx, ny}); 
                    }
                }
            }


        }
        return -1;
    }
}