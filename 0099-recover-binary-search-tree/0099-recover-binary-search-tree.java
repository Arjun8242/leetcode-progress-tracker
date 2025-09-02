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
    public void recoverTree(TreeNode root) {
        List<Integer> inorder=new ArrayList<>();
        inorder(root,inorder);
        List<Integer> sortedlist=new ArrayList<>(inorder);
        Collections.sort(sortedlist);
        int first=-1, second=-1;
        for(int i=0;i<sortedlist.size();i++){
            if(sortedlist.get(i)!=inorder.get(i)){
                if(first==-1) first=sortedlist.get(i);
                else second=sortedlist.get(i);
            }
        }
        fixtree(root, first, second);
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root==null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public void fixtree(TreeNode root, int first, int second){
        if(root==null) return;
        fixtree(root.left, first, second);
        if(root.val==first) root.val=second;
        else if(root.val==second) root.val=first;
        fixtree(root.right, first, second);
    }
}