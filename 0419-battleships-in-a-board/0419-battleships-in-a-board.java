class Solution {
    int m, n;
    public int countBattleships(char[][] board) {
        m=board.length;
        n=board[0].length;
        boolean[][] vis=new boolean[m][n];
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X' && !vis[i][j]){
                    dfs(board, vis, i, j);
                    count++;
                }
            }
        }
        return count;

    }
    public void dfs(char[][] board, boolean[][] vis, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n) return;
        if(board[i][j]!='X' || vis[i][j]) return;

        vis[i][j]=true;

        dfs(board, vis, i+1, j);
        dfs(board, vis, i-1, j);
        dfs(board, vis, i, j+1);
        dfs(board, vis, i, j-1);
    }
}