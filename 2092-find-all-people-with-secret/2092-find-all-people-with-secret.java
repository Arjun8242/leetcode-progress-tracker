class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<Integer> ans=new ArrayList<>();
        boolean[] knows=new boolean[n];
        Arrays.sort(meetings, (a,b) -> a[2]-b[2]);
        knows[0]=true;
        knows[firstPerson]=true;
        int i=0;
        int m=meetings.length;

        while(i<m){
            int time=meetings[i][2];

            Map<Integer, List<Integer>> graph=new HashMap<>();
            Set<Integer> people=new HashSet<>();

            while(i<m && meetings[i][2]==time){
                int x=meetings[i][0];
                int y=meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);
                i++;
            }

            Set<Integer> visited=new HashSet<>();
            Set<Integer> newlyknow=new HashSet<>();

            for(int p: people){
                if(visited.contains(p)) continue;
                
                Queue<Integer> queue=new LinkedList<>();
                List<Integer> component=new ArrayList<>();

                queue.offer(p);
                visited.add(p);

                boolean secret=knows[p];

                while(!queue.isEmpty()){
                    int curr=queue.poll();
                    component.add(curr);

                    for(int nei:graph.getOrDefault(curr, List.of())){
                        if(!visited.contains(nei)){
                            visited.add(nei);
                            queue.offer(nei);
                            if(knows[nei]) secret=true;
                        }
                    }
                }

                if(secret){
                    newlyknow.addAll(component);
                }
            }

            for(int p: newlyknow){
                knows[p]=true;
            }
        }
        for(int j=0;j<n;j++){
            if(knows[j]) ans.add(j);
        }
        return ans;
    }
}