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
    public void flatten(TreeNode root) {
        /*List<TreeNode> list=new ArrayList<>();
        preorder(root, list);
        int size=list.size()-1;
        for(int i=0;i<size;i++){
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
    }
    public void preorder(TreeNode root, List<TreeNode> list){
        if(root==null)return ;

        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }*/
    while(root!=null){
        if(root.left!=null){
            TreeNode temp=root.left;
            while(temp.right!=null){
                temp=temp.right;
            }
            temp.right=root.right;
            root.right=root.left;
            root.left=null;
        }
        root=root.right;
    }
    }
}