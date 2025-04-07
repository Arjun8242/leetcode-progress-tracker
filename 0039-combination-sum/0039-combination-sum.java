class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(candidates,target,0,new ArrayList<>(),0 ,ans);
        return ans;
    }
    void recursion(int[] candidates, int target, int ind, List<Integer> comb, int total,List<List<Integer>> ans){

        if(total==target){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(total>target || ind>=candidates.length){
            return;
        }
        comb.add(candidates[ind]);
        recursion(candidates, target, ind, comb, total+candidates[ind], ans);
        comb.remove(comb.size()-1);
        recursion(candidates, target, ind+1, comb, total, ans);


    }

}