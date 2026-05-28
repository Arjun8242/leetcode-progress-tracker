class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;

        for(int i=0;i<n;i++){
            //edgecase which i don't know

            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                
                if(sum==0){
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
}