class Solution {
    public int largestIsland(int[][] grid) {
        //first passtoo count number of island and assign them into ids for extraction
        int n=grid.length;
        Map<Integer, Integer> map=new HashMap<>();
        int id=2, max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int size=dfs(grid, i, j, id);
                    map.put(id, size);
                    id++;
                }
            }
        }

            //second pass to calculate connected components attached to each cell 
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j]==0){
                    Set<Integer> set=new HashSet<>();
                    int size=1;
                    int[][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};
                    for(int[] d:dirs){
                        int x=i+d[0], y=j+d[1];
                        if(x>=0 && y>=0 && y<n && x<n && grid[x][y]>1){
                            if(set.add(grid[x][y])){
                                size+=map.get(grid[x][y]);
                            }
                        }
                    }
                    max=Math.max(size, max);
                    }
                }
            }
            return max==0?n*n:max; 
    }
    public int dfs(int[][] grid, int i, int j, int id){
        int n = grid.length;
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = id; // mark with island ID
        int size = 1;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] d : dirs) {
            size += dfs(grid, i + d[0], j + d[1], id);
        }

        return size;
    }
    // public int bfs(int[][] grid, int i, int j, int id){
        // int n=grid.length;
        // Queue<int[]> queue=new LinkedList<>();
        // queue.offer(new int[]{i, j});
        // grid[i][j]=id;
        // int size=1;
        // int[][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};
        // while(!queue.isEmpty()){
        //     int[] curr=queue.poll();
        //     for(int[] d: dirs){
        //         int x=curr[0]+d[0], y=curr[1]+d[1];
        //         if(x>=0 && y>=0 && y<n && x<n && grid[x][y]==1){
        //             queue.offer(new int[]{x,y});
        //             grid[x][y]=id;
        //             size++;
        //         }
        //     }
        // }
        // return size;
    // }
}