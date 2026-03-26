class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        return checkHorizontal(grid) || checkVertical(grid);
    }

    public boolean remove(int[][] grid, int r1, int r2, int c1, int c2, long diff, Map<Integer, Integer> map){
        int height=r2-r1+1;
        int width=c2-c1+1;

        if(height>1 && width>1){
            return map.getOrDefault((int)diff, 0)>0;
        }

        if(height==1){
            return grid[r1][c1] == diff || grid[r1][c2] == diff;
        }
        else if(width==1){
            return grid[r1][c1] == diff || grid[r2][c1] == diff;
        }
        
        return false;
    }

    public boolean checkHorizontal(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        long totsum=0;
        long prefix=0;
        HashMap<Integer, Integer> totElementMap=new HashMap<>();
        HashMap<Integer, Integer> prefixElementMap=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=grid[i][j];
                totsum+=val;
                totElementMap.put(val, totElementMap.getOrDefault(val, 0) + 1);
            }
        }

        for(int i=0;i<m-1;i++){
            for(int j=0;j<n;j++){
                int val=grid[i][j];
                prefix+=val;
                prefixElementMap.put(val, prefixElementMap.getOrDefault(val, 0) + 1);
                totElementMap.put(val, totElementMap.get(val) - 1);
                if(totElementMap.get(val)==0) totElementMap.remove(val);
            }

            long diff=totsum-prefix;

            if(prefix==diff) return true;

            long prefixDiff=Math.abs(prefix-diff);

            if(prefix>diff){
                if(remove(grid, 0, i, 0, n-1, prefixDiff, prefixElementMap)) return true;
            }
            else{
                if(remove(grid, i+1, m-1, 0, n-1, prefixDiff, totElementMap)) return true;
            }
        }
        return false;

    }

    public boolean checkVertical(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        long totsum=0;
        long prefix=0;
        HashMap<Integer, Integer> totElementMap=new HashMap<>();
        HashMap<Integer, Integer> prefixElementMap=new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int val=grid[i][j];
                totsum+=val;
                totElementMap.put(val, totElementMap.getOrDefault(val, 0) + 1);
            }
        }

        for(int j=0;j<n-1;j++){
            for(int i=0;i<m;i++){
                int val=grid[i][j];
                prefix+=val;
                prefixElementMap.put(val, prefixElementMap.getOrDefault(val, 0) + 1);
                totElementMap.put(val, totElementMap.get(val) - 1);
                if(totElementMap.get(val)==0) totElementMap.remove(val);
            }

            long diff=totsum-prefix;

            if(prefix==diff) return true;

            long prefixDiff=Math.abs(prefix-diff);

            if(prefix>diff){
                if(remove(grid, 0, m-1, 0, j, prefixDiff, prefixElementMap)) return true;
            }
            else{
                if(remove(grid, 0, m-1, j+1, n-1, prefixDiff, totElementMap)) return true;
            }
        }
        return false;

    }
}