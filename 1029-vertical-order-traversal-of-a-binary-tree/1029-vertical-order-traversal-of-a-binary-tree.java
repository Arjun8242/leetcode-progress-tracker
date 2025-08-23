/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer, PriorityQueue<int[]>> colmap=new HashMap<>();
        dfs(root, 0, 0, colmap);

        int maxcol=Integer.MIN_VALUE;
        int mincol=Integer.MAX_VALUE;

        for(int col:colmap.keySet()){
            mincol=Math.min(mincol,col);
            maxcol=Math.max(maxcol,col);
        }
        for(int col=mincol;col<=maxcol;col++){
            PriorityQueue<int[]> pq=colmap.get(col);
            List<Integer>collist=new ArrayList<>();
            while(!pq.isEmpty()){
                collist.add(pq.poll()[1]);
            }
            ans.add(collist);
        }
        return ans;
    }

    public void dfs(TreeNode root, int row, int col, Map<Integer, PriorityQueue<int[]>> colmap){

        if(root==null)return ;

        colmap.putIfAbsent(col,new PriorityQueue<>(
            (a,b) -> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]
        ));
        colmap.get(col).offer(new int[]{row,root.val});

        dfs(root.left, row+1, col-1, colmap);
        dfs(root.right, row+1, col+1, colmap);
    }
}