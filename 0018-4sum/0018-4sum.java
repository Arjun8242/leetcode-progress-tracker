class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> List=new ArrayList<>();
        for(int h=0;h<nums.length;h++){
            if (h > 0 && nums[h] == nums[h - 1]) {
                continue;
            }
       for(int i=h+1;i<nums.length;i++){
        if(i>h+1 && nums[i]==nums[i-1] ){
            continue;
        }
        
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
                long sum=(long)nums[h]+nums[i]+nums[j]+nums[k];
                if(sum>target){
                    k--;
                }
                else if(sum<target){
                    j++;
                }
                else{
                    List.add(Arrays.asList(nums[h],nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    
                    while(nums[j]==nums[j-1] && j<k){
                       j++;
                    }
                    
                }
            }
        }
        }
        return List;
    }

}