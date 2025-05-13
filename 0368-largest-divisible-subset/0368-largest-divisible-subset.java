class Solution {
    List<Integer> ans=new ArrayList<>();
    int [] memo;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        memo=new int[nums.length];
        Arrays.sort(nums);
        Arrays.fill(memo,-1);
        dp(nums,0,1,new ArrayList<>());
        return ans;
        
    }
    public void dp(int[] nums,int ind,int prev,List<Integer> curr){
        if(curr.size()>ans.size()){
            ans=new ArrayList<>(curr);
              }
            
            for(int i=ind;i<nums.length;i++){
                if(curr.size()>memo[i] && nums[i]%prev==0){
                    memo[i]=curr.size();
                    curr.add(nums[i]);
                    dp(nums,i+1,nums[i],curr);
                    curr.remove(curr.size()-1);
                }
            }
    }
}