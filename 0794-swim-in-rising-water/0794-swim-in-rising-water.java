class Solution {
    public int swimInWater(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dist=new int[row][col];
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minheap.add(new int[]{grid[0][0],0,0});
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=grid[0][0];
        int[][] dirs={{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!minheap.isEmpty()){
            int[] top=minheap.poll();
            int maxpath=top[0], x=top[1], y=top[2];
            if(x==row-1 && y==col-1) return maxpath;
            for(int[] d:dirs){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx<=row-1 && nx>=0 && ny<=col-1 && ny>=0){
                int newmaxpath=Math.max(maxpath, grid[nx][ny]);
                if(newmaxpath<dist[nx][ny]){
                    dist[nx][ny]=newmaxpath;
                    minheap.add(new int[]{ newmaxpath, nx, ny});
                }
            }
        }
    }
        return -1;
    }
}