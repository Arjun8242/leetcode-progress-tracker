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
    public int maxLevelSum(TreeNode root) {
        int h=height(root);
        int[] levelSum=new int[h+1];
        dfs(root, 1, levelSum);

        int max=Integer.MIN_VALUE;
        int ans=0;

        for(int i=1;i<levelSum.length;i++){
            if(levelSum[i]>max){
                max=levelSum[i];
                ans=i;
            }
        }
        return ans;
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
    public void dfs(TreeNode root, int level, int[] levelSum){
        if(root==null) return ;

        levelSum[level]+=root.val;
        dfs(root.left, level+1, levelSum);
        dfs(root.right, level+1, levelSum);
    }

}