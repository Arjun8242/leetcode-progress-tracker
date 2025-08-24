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
        Map<Integer, Integer> treeind=new HashMap<>();
        int maxwidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root,0,0);
        return maxwidth;
    }
    public void dfs(TreeNode node, int depth, int index){

        if(node==null)return;

        treeind.putIfAbsent(depth, index);

        maxwidth=Math.max(maxwidth,(index-treeind.get(depth))+1);

        dfs(node.left, depth+1, index*2);
        dfs(node.right, depth+1, index*2+1);
    }
}