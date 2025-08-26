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
    int postorderindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderindex=postorder.length-1;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildtree(inorder, postorder, 0, postorder.length-1, map);
    }
    public TreeNode buildtree(int[] inorder, int[] postorder, int start, int end, Map<Integer, Integer> map){
        if(start>end) return null;

        int rootval=postorder[postorderindex--];
        TreeNode node=new TreeNode(rootval);

        int inorderindex=map.get(rootval);
        
        node.right=buildtree(inorder, postorder, inorderindex+1, end, map);
        node.left=buildtree(inorder, postorder, start, inorderindex-1, map);

        return node;
    }
}