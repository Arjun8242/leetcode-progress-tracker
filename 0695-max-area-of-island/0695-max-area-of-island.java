class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int count=0;
        int area=0;
        int maxarea=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                area=dfs(grid, vis, i, j);
                maxarea=Math.max(area, maxarea);
            }
        }
    }
    return maxarea;
}

public int dfs(int[][] grid, boolean[][] vis, int i, int j){
    if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1)  return 0;
    if(vis[i][j] || grid[i][j]==0) return 0;

    vis[i][j]=true;

    return 1+
            dfs(grid, vis, i-1, j) +
            dfs(grid, vis, i, j-1) +
            dfs(grid, vis, i+1, j) +
            dfs(grid, vis, i, j+1);

    }
}