class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int[] row:grid){
            for(int i:row){
                if(i<0) count++;
            }
        }
        return count++;
    }
}