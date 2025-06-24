class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> index=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==key){
                index.add(i);
            }
        }

        for(int i=0;i<n;i++){
            for(int j:index){
                if(Math.abs(i-j)<=k){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}