class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Boolean[] Map=new Boolean[nums.length];
        Arrays.fill(Map, false);
        recursive(nums,ans,temp,Map);
        return ans;
    }
    void recursive(int[] nums, List<List<Integer>> ans, List<Integer> temp,  Boolean[] Map){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(Map[i]==false){
                Map[i]=true;
                temp.add(nums[i]);
                recursive(nums, ans, temp, Map);
                                Map[i]=false;
                temp.remove(temp.size()-1);

            }
        }
       
    }
}