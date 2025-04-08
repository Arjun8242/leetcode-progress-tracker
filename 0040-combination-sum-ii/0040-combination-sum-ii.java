class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates,target,0,new ArrayList<>(),0 ,ans);
        return ans;
    }
    void recursion(int[] candidates, int target, int ind, List<Integer> comb, int total,List<List<Integer>> ans){

         if(total==target){
            ans.add(new ArrayList<>(comb));
            return;
        }
        
        if(total>target){
            return;
            
        }
        for(int i=ind;i<candidates.length;i++){

            if(i>ind && candidates[i]==candidates[i-1]){continue;}
            
             if (candidates[i] + total > target) break;
        
        comb.add(candidates[i]);
        recursion(candidates, target, i+1, comb, total+candidates[i], ans);
        comb.remove(comb.size()-1);
        
        }

    }
}