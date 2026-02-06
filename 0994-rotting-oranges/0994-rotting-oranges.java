class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int n=grid[0].length;
        int m=grid.length;
        int total=0;
        int days=0;
        int count=0;
        int[][] dirs={{0,1}, {1,0}, {0,-1}, {-1,0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }
                else if(grid[i][j]==1){
                    total++;
                }
            }
        }

        if(total==0) return 0;

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] cell=queue.poll();
                int x=cell[0];
                int y=cell[1];
                for(int[] d:dirs){
                    int nx=x+d[0];
                    int ny=y+d[1];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        queue.offer(new int[]{nx, ny});
                        count++;
                    }
                }
            }
            days++;
        }
        days = days > 0 ? days - 1 : days;
        return total==count?days:-1;
    }
}