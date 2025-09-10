class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int count=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && (grid[i][j]==1)){
                    queue.add(new int[] {i, j});
                    vis[i][j]=true;
                }
            }
        }

        int[][] dirs={{1,0}, {0,1}, {-1,0}, {0,-1}};
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int x=cell[0];
            int y=cell[1];
            for(int[] d:dirs){
                int i=x+d[0];
                int j=y+d[1];
                if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==1 && !vis[i][j]){
                    vis[i][j]=true;
                    queue.add(new int[] {i, j});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]==1) count++;
            }
        }
        return count;
    }
}