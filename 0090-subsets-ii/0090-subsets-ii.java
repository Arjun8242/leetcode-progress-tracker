class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
          List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        recursion(nums,0,new ArrayList<>(),ans);
        return ans;
    }
     void recursion(int[] nums, int ind, List<Integer> recursive,List<List<Integer>> ans){
      
        ans.add(new ArrayList<>(recursive));
      
       
       for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1])continue;
            recursive.add(nums[i]);
            recursion(nums,i+1,recursive,ans);
            recursive.remove(recursive.size()-1);
       }
        }

}