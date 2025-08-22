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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null) return ans;
        queue.offer(root);
        int count=0;
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
           int size=queue.size();
           for(int i=0;i<size;i++){
            TreeNode node=queue.poll();
            temp.add(node.val);

            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);

           }
                if(count%2==1) Collections.reverse(temp);
                count++;
                ans.add(temp);
        }
        return ans;
    }
}