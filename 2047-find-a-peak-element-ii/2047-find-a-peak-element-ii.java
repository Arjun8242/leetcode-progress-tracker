class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=0;
        int high=n-1;int mid;
        while(low<=high){
            mid=(low+high)/2;
            int maxrow=0;
            for(int i=0;i<m;i++){
                if(mat[maxrow][mid]<mat[i][mid]){
                maxrow=i;
                }
            }
                if((mid==0 || mat[maxrow][mid]>mat[maxrow][mid-1]) &&(mid==n-1 || mat[maxrow][mid]>mat[maxrow][mid+1]))
                return new int[] {maxrow,mid};

                else if(mid>0 && mat[maxrow][mid-1]>mat[maxrow][mid])
                {
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
        }
        return new int[]{-1,-1};
    }
}