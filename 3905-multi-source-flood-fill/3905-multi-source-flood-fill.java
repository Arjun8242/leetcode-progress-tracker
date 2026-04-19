class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] time=new int[n][m];
        int[][] color=new int[n][m];

        for(int[] row: time){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<int[]> q=new LinkedList<>();


        for(int[] s:sources){
            int r=s[0];
            int c=s[1];
            int col=s[2];
            q.offer(new int[]{r, c, 0, col});
            time[r][c]=0;
            color[r][c]=col;
        }

        int[][] dirs={{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int currtime=curr[2];
            int col=curr[3];

            for(int[] d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nc<0 || nr>=n || nc>=m) continue;

                int newtime=currtime+1;

                if(newtime<time[nr][nc]){
                    time[nr][nc]=newtime;
                    color[nr][nc]=col;
                    q.offer(new int[]{nr, nc, newtime, col});
                }
                else if(newtime==time[nr][nc] && col>color[nr][nc]){
                    color[nr][nc]=col;
                    q.offer(new int[] {nr, nc, newtime, col});
                }
            }
        }
        return color;
    }
}