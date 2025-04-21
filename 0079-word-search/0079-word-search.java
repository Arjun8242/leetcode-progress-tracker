class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        boolean found=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    found=dfs(board,i,j,word,0);
                    if(found)return true;
                }
            }
        }
        return false;
    }
    Boolean dfs(char[][]board, int i,int j,String word,int wordindex){
        if(word.length()==wordindex)return true;

        if(i==-1 || i==board.length || j==-1 || j==board[0].length)
        return false;

        if(board[i][j]==' ' || board[i][j]!=word.charAt(wordindex)){
            return false;
        }

            char ch=board[i][j];
            board[i][j]=' ';

            if(dfs(board, i-1, j, word, wordindex+1) || dfs(board, i, j+1, word, wordindex+1) || dfs(board, i+1, j, word, wordindex+1)  || dfs(board, i, j-1, word, wordindex+1)){
                return true;
            }
            board[i][j]=ch;
            return false;
            
    }
}