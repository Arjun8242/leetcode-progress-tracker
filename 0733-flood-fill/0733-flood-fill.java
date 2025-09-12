class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int oldcolor=image[sr][sc];
        dfs(sr, sc, image, color, oldcolor);

        return image;
    }
    public void dfs(int row, int col, int[][] image, int color, int oldcolor){

        if(row<0 || col<0 || row>=image.length || col>=image[0].length) return;
        if(image[row][col]!=oldcolor) return;

        image[row][col]=color;

        dfs(row+1, col, image, color, oldcolor);
        dfs(row-1, col, image, color, oldcolor);
        dfs(row, col-1, image, color, oldcolor);
        dfs(row, col+1, image, color, oldcolor);

    }
}