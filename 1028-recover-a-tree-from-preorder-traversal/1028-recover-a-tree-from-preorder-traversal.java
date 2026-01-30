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

    static class Pair{
        int val;
        int depth;
        Pair(int v, int d){
            val=v;
            depth=d;
        }
    }

    int ind=0;

    public TreeNode recoverFromPreorder(String traversal) {
        List<Pair> list=parse(traversal);
        return dfs(list, 0);
    }
    public List<Pair> parse(String s){
        List<Pair> list=new ArrayList<>();
        int n=s.length();
        int i=0;

        while(i<n){

            int depth=0;
            while(i<n && s.charAt(i)=='-'){
                depth++;
                i++;
            }
            
            int val=0;
            while(i<n && Character.isDigit(s.charAt(i))){
                val=val*10+(s.charAt(i)-'0');
                i++;
            }
    
            list.add(new Pair(val, depth));
        }
        return list;
    }

    public TreeNode dfs(List<Pair> list, int expectedDepth){
        if(ind>=list.size() || list.get(ind).depth!=expectedDepth){
            return null;
        }

        Pair p=list.get(ind++);
        TreeNode node=new TreeNode(p.val);

        node.left=dfs(list, expectedDepth+1);
        node.right=dfs(list, expectedDepth+1);

        return node;
    }
}