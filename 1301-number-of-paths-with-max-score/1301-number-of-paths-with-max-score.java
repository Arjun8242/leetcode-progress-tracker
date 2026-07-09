class Solution {

    int[][] dp;
    boolean[][] vis;
    int[][] ways;
    boolean[][] visways;
    int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        dp=new int[n][n];
        vis=new boolean[n][n];
        ways=new int[n][n];
        visways=new boolean[n][n];

        int maxscore=dfs(n-1, n-1, board);

        if (maxscore == -1) return new int[]{0, 0}; 

        int count = dfsways(n - 1, n - 1, board);

        return new int[]{maxscore, count};
        
    }

    public int dfs(int i, int j, List<String> board){
        if(i<0 || j<0) return -1;

        if(board.get(i).charAt(j)=='X') return -1;

        if(board.get(i).charAt(j)=='E') return 0;

        if(vis[i][j]){
            return dp[i][j];
        }

        vis[i][j]=true;

        int up=dfs(i-1, j, board);
        int left=dfs(i, j-1, board);
        int upleft=dfs(i-1, j-1, board);

        int max=Math.max(up, Math.max(left, upleft));

        if(max==-1){
            dp[i][j]=-1;
            return -1;
        }
        char ch=board.get(i).charAt(j);
        int val=(ch == 'S') ? 0 : ch - '0';

        dp[i][j] = max + val;
                
        return dp[i][j];
    }

    public int dfsways(int i, int j, List<String> board){
        if (i < 0 || j < 0)
            return 0;

        char ch = board.get(i).charAt(j);

        if (ch == 'X')
            return 0;

        if (dp[i][j] == -1)
            return 0;

        if (ch == 'E')
            return 1;

        if (visways[i][j])
            return ways[i][j];

        visways[i][j] = true;

        int val = (ch == 'S') ? 0 : ch - '0';
        int target = dp[i][j] - val;

        int ans = 0;

        if (i > 0 && dp[i - 1][j] == target)
            ans = (ans + dfsways(i - 1, j, board)) % MOD;

        if (j > 0 && dp[i][j - 1] == target)
            ans = (ans + dfsways(i, j - 1, board)) % MOD;

        if (i > 0 && j > 0 && dp[i - 1][j - 1] == target)
            ans = (ans + dfsways(i - 1, j - 1, board)) % MOD;

        ways[i][j] = ans;
        return ans;

    }
}