class Solution {
    public int totalNQueens(int n) {
        char [][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        return queens(board,0);
    }
    static int queens(char[][] board,int row){
        if(row==board.length){
            return 1;
        }
        int count=0;
        for(int col=0;col<board.length;col++){
            if(issafesquare(board,row,col)){
                board[row][col]='Q';
                count+=queens(board,row+1);
                board[row][col]='.';
            }
        }
        return count;
    }
    static boolean issafesquare(char[][] board,int row, int col){
        for(int i=0;i<row;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        int left_diagonal=Math.min(row,col);
        for(int i=1;i<=left_diagonal;i++){
            if(board[row-i][col-i]=='Q'){
                return false;
            }
        }

        int right_diagonal=Math.min(row,board.length-1-col);
        for(int i=1;i<=right_diagonal;i++){
            if(board[row-i][col+i]=='Q'){
                return false;
            }
        }
        return true;
    }
}

