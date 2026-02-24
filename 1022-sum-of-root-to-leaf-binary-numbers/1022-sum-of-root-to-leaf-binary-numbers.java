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
    public int sumRootToLeaf(TreeNode root) {
        List<String> list=new ArrayList<>();

        dfs(list, root, "");

        int sum=0;
        for(String path:list){
            sum+=Integer.parseInt(path, 2);
        }

        return sum;
        
    }
    public void dfs(List<String> list, TreeNode root, String sum){
        if(root==null){
            return;
        }

        sum=sum+root.val;

        if(root.right==null && root.left==null){
            list.add(sum);
        }

        dfs(list, root.right, sum);
        dfs(list, root.left, sum);
    }
}