class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        long[] rowSums = new long[m];
        long[] colSums = new long[n];
long totsum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val = grid[i][j];
                rowSums[i] += val;
                colSums[j] += val;
                totsum += val;
            }
        }
        
            long topsum=0;
            for (int i=0;i < m - 1; i++) {
            topsum += rowSums[i];
            long bottomsum = totsum - topsum;
            if (topsum == bottomsum) return true;
        }

        
            long leftsum=0;
           for (int j = 0; j < n - 1; j++) {
            leftsum += colSums[j];
            long rightsum = totsum - leftsum;
            if (leftsum == rightsum) return true;
        }

        return false;
        
        }
    }
