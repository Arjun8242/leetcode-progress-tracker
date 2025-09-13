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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();

        dfs(root, ans, targetSum, 0, new ArrayList<>());

        return ans;
    }
    public void dfs(TreeNode root, List<List<Integer>> ans, int targetSum, int sum, List<Integer> curr){
        if(root==null) return;

        sum+=root.val;
        curr.add(root.val);

        if(root.right==null && root.left==null && sum==targetSum) ans.add(new ArrayList<>(curr));

        dfs(root.left, ans, targetSum, sum, curr);
        dfs(root.right, ans, targetSum, sum, curr);

        curr.remove(curr.size()-1);
    }
}