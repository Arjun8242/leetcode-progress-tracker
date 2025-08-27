/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> res=new ArrayList<>();
        serial(root,res);
        return res.toString();
    }
    public void serial(TreeNode root, ArrayList<String> res){
        if(root==null){
            res.add(null);
            return ;
        }
        res.add(String.valueOf(root.val));
        serial(root.left, res);
        serial(root.right, res);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    String content=data.substring(1, data.length()-1);
    String[] values=content.split(", ");
    Queue<String> queue= new LinkedList<>(Arrays.asList(values));
    return deserial(queue);
    }

    public TreeNode deserial(Queue<String> queue){
       if(queue.isEmpty()) return null;
       
       String element=queue.poll();
       if(element.equals("null"))return null;

       TreeNode root= new TreeNode(Integer.parseInt(element));
       root.left=deserial(queue);
       root.right=deserial(queue);
       return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));