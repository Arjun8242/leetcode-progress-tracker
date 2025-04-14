class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        recursion(1,k,n,new ArrayList<>(),ans);
        return ans;
        
    }
    public void recursion(int start, int k, int n, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size()==k && n==0){
            List<Integer> temp=new ArrayList<Integer>(curr);
            ans.add(temp);
            return;
        }
        for(int i=start;i<=9;i++){
            curr.add(i);
        recursion(i+1,k,n-i,curr,ans);
        curr.remove(curr.size()-1);
    }
    }
}