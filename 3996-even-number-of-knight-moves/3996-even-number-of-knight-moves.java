class Solution {

    int[][] dir = {
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
    };

    boolean[][][] visited = new boolean[8][8][2];
    public boolean canReach(int[] start, int[] target) {
        return dfs(start[0], start[1], target[0], target[1], 0);
    }

    public boolean dfs(int x, int y, int a, int b, int moves){
        if (x < 0 || x >= 8 || y < 0 || y >= 8)
            return false;

        if (visited[x][y][moves % 2])
            return false;

        visited[x][y][moves % 2] = true;

        if (x == a && y == b && moves % 2 == 0)
            return true;

        for (int[] d : dir) {
            if (dfs(x + d[0], y + d[1], a, b, moves + 1))
                return true;
        }

        return false;
        
    }
}