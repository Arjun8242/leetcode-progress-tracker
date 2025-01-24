class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length;
        int n=matrix.length;
        int row=0;
        int column=m-1;
        while(row<n && column>=0){
            if(matrix[row][column]==target){
                return true;
            }
            else if(matrix[row][column]<target){
                row++;
            }
            else{
                column--;
            }
        }
        return false;        
    }
}