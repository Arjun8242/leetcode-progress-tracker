class Solution {
    class Node{
        Map<String, Node> children=new HashMap<>();
        String name;
        boolean deleted=false;
        Node(String name){
            this.name=name;
        }
    }
    Map<String, Integer> serialcount=new HashMap<>();
    Map<String, List<Node>> serialmap=new HashMap<>();
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root=new Node("");

        for(List<String> path:paths){
            Node curr=root;
            for(String folder:path){
                curr.children.putIfAbsent(folder, new Node(folder));
                curr=curr.children.get(folder);
            }
        }

        serialize(root);

        for(Map.Entry<String, List<Node>> entry:serialmap.entrySet()){
            if(serialcount.get(entry.getKey())>1)
            {
                for(Node node:entry.getValue()){
                    node.deleted=true;
            }
        }
    }

    List<List<String>> res=new ArrayList<>();
    dfs(root, new ArrayList<>(), res);
    return res;
}

public void dfs(Node node, List<String> path, List<List<String>> res){
    if(!node.name.equals("") && !node.deleted){
        path.add(node.name);
        res.add(new ArrayList<>(path));
    }

    for(Node child: node.children.values()){
        if(!child.deleted){
            dfs(child, path, res);
        }
    }

    if(!path.isEmpty()) path.remove(path.size()-1);
    }

    public String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(node.children.keySet());
        Collections.sort(keys); // To keep consistent serialization

        for (String key : keys) {
            Node child = node.children.get(key);
            String subSerial = serialize(child);
            sb.append("(").append(key).append(subSerial).append(")");
        }

        String serial = sb.toString();
        if (!serial.isEmpty()) {
            serialcount.put(serial, serialcount.getOrDefault(serial, 0) + 1);
            serialmap.computeIfAbsent(serial, x -> new ArrayList<>()).add(node);
        }

        return serial;
    }
}