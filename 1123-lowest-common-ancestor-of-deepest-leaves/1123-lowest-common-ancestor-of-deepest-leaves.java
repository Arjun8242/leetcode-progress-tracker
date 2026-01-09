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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null) return root;

        List<TreeNode> deepest=getdeepestnode(root);//find deepest node using BFSand store them all in list.
        TreeNode ans=deepest.get(0);

        for(int i=0;i<deepest.size();i++){
            ans=lca(root, ans, deepest.get(i));
        }
        return ans;
    }
    public List<TreeNode> getdeepestnode(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        List<TreeNode> level=new ArrayList<>();//to store all the nodes at the last lebel.
        while(!queue.isEmpty()){
            int size=queue.size();
            level=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                level.add(node);

                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return level;
    }
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root== q) return root;

        TreeNode left=lca(root.left, p, q);
        TreeNode right=lca(root.right, p, q);

        if(left==null) return right;

        if(right==null)return left;

        return root;
    }
}