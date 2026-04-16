class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        Map<Integer, List<Integer>> map=new HashMap<>();
        int[] ans=new int[n];
        Arrays.fill(ans, -1);

        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list: map.values()){
            int size=list.size();
            if(size==1) continue;

            for(int i=0;i<size;i++){
                int curr=list.get(i);
                int prev=list.get((i-1+size)%size);
                int next=list.get((i+1)%size);

                int d1=Math.min(Math.abs(curr-prev), n-Math.abs(curr-prev));
                int d2=Math.min(Math.abs(curr-next), n-Math.abs(curr-next));

                ans[curr]=Math.min(d1, d2);
            }
        }

        List<Integer> list=new ArrayList<>();
        for(int q:queries){
            list.add(ans[q]);
        }

        return list;

    }
}