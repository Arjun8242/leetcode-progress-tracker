class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int high=m*n-1;
        int mid;
        int row;int column;
        while(low<=high){
            mid=(low+high)/2;
            row=mid/n;
            column=mid%n;
            if(matrix[row][column]==target){
                return true;
            }
            else if(matrix[row][column]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
        
    }
}