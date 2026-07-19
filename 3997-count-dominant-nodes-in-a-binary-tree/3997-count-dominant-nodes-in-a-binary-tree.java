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
    int count=0;
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return count;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        if(root.left==null && root.right==null){
            count++;
            return root.val;
        }

        int left=dfs(root.left);
        int right=dfs(root.right);

        if(root.val>=left && root.val>=right) count++;

        return Math.max(root.val, Math.max(left, right));

    } 
}