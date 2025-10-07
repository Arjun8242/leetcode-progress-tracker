class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graph=new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for(List<String> acc:accounts){
            String name=acc.get(0);
            for(int i=1;i<acc.size();i++){
                emailToName.put(acc.get(i), name);
                graph.putIfAbsent(acc.get(i), new ArrayList<>());
                graph.get(acc.get(1)).add(acc.get(i));
                graph.get(acc.get(i)).add(acc.get(1));
            }
        }

        Set<String> vis=new HashSet<>();
        List<List<String>> ans=new ArrayList<>();
        for(String email:graph.keySet()){
            if(!vis.contains(email)){
                List<String> comp=new ArrayList<>();
                dfs(email, graph, vis, comp);
                Collections.sort(comp);
                comp.add(0, emailToName.get(email));
                ans.add(comp);
            }
        }
        return ans;
    }
    public void dfs(String email, Map<String, List<String>> graph, Set<String> vis, List<String> comp){
        vis.add(email);
        comp.add(email);
        for(String nei: graph.getOrDefault(email, new ArrayList<>())){
            if(!vis.contains(nei)){
                dfs(nei, graph, vis, comp);
            }
        }
    }
}