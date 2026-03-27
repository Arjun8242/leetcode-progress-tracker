class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] shifted=new int[m][n];
        int totShift=k%n;
        
        for(int i=0;i<m;i++){
            if(i%2==0){
                for(int j=0;j<n;j++){
                    shifted[i][j]=mat[i][(j-totShift+n)%n];
                }
            }
            else{
                for(int j=0;j<n;j++){
                    shifted[i][j]=mat[i][(j+totShift)%n];
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=shifted[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}