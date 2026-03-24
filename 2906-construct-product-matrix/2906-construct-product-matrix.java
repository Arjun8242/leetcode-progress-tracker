class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] product = new int[m][n];

        int prefix=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                product[i][j]=prefix;
                prefix = (int)((1L * prefix * grid[i][j]) % 12345);
            }
        }
        
        int suffix=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                product[i][j]=(int)(1L*product[i][j]*suffix)%12345;
                suffix = (int)((1L * suffix * grid[i][j]) % 12345);
            }
        }

        return product;
    }
}