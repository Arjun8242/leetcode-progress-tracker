class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>> ans=new ArrayList<>();
        queens(board,0,ans);
        return ans;
    }
    static void queens(char[][] board,int row ,List<List<String>>ans){
        if(row==board.length){
            ans.add(construct(board));
            return;
        }
        for(int col=0;col<board.length;col++){
            if(issafesquare(board,row,col)){
                board[row][col]='Q';
                queens(board,row+1,ans);
                board[row][col]='.';
            }
        }
    }

    static List<String> construct(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String row =new String(board[i]);
            temp.add(row);
        }
        return temp;
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