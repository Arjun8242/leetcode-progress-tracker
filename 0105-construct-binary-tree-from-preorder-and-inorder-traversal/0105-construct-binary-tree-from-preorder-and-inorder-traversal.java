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
    int preorderindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildtree(preorder, inorder, 0, preorder.length-1, map);
    }
    public TreeNode buildtree(int[] preorder, int[] inorder, int start, int end, Map<Integer, Integer> map){
        if(start>end)  return null;

        int rootval=preorder[preorderindex++];
        TreeNode node = new TreeNode(rootval);

        int inorderindex = map.get(rootval);

        node.left=buildtree(preorder, inorder, start, inorderindex-1, map);
        node.right=buildtree(preorder, inorder, inorderindex+1, end, map);

        return node;            
    }
}