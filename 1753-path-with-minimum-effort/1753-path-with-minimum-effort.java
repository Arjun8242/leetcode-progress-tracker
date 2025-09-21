class Solution {
    public int minimumEffortPath(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        int[][] dist=new int[row][col];
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minheap.add(new int[]{0,0,0});
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int[][] dirs={{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!minheap.isEmpty()){
            int[] top=minheap.poll();
            int effort=top[0], x=top[1], y=top[2];
            if(x==row-1 && y==col-1) return effort;
            for(int[] d:dirs){
                int nx=x+d[0];
                int ny=y+d[1];
                if(nx<=row-1 && nx>=0 && ny<=col-1 && ny>=0){
                    int neweffort=Math.max(effort, Math.abs(heights[x][y]-heights[nx][ny]));
                    if(neweffort<dist[nx][ny]){
                        dist[nx][ny]=neweffort;
                        minheap.add(new int[]{ neweffort, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}