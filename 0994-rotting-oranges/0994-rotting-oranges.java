class Solution {
    public int orangesRotting(int[][] grid) {
        int total=0;
        int count=0;
        int days=0;
        int[][] dirs={{1,0}, {0,1}, {-1,0}, {0,-1}};
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    total++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if(total==0) return 0;

        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rotten=false;
            for(int s=0;s<size;s++){
                int[] cell=queue.poll();
                int r=cell[0], c=cell[1];
                for(int[] d:dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        queue.offer(new int[]{nr, nc});
                        count++;
                        rotten=true;
                    }
                }
            }
            if(rotten) days++;
        }
        return count==total?days:-1;



    }
}