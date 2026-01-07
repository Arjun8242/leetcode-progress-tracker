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
    static final int mod= 1_000_000_007;
    long totsum;
    long maxpdt;
    public int maxProduct(TreeNode root) {
        totsum=totalsum(root);
        dfs(root);
        return (int)(maxpdt%mod);
    }
    public int totalsum(TreeNode node){
        if(node==null) return 0;

        return node.val+totalsum(node.left)+totalsum(node.right);
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;

        int left=dfs(node.left);
        int right=dfs(node.right);

        int subtreesum=node.val + left + right;
        maxpdt=Math.max(maxpdt, subtreesum*(totsum-subtreesum));

        return subtreesum;
    }
}