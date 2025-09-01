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
    public boolean findTarget(TreeNode root, int k) {
        /*List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            if(set.contains(k-list.get(i))) return true;
            set.add(list.get(i));
        }
        return false;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return ;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);*/
          Set<Integer> seen = new HashSet<>();
        return dfs(root, k, seen);
    }

    public boolean dfs(TreeNode node, int k, Set<Integer> seen) {
        if (node == null) return false;
        if (seen.contains(k - node.val)) return true;
        seen.add(node.val);
        return dfs(node.left, k, seen) || dfs(node.right, k, seen);
    }
}