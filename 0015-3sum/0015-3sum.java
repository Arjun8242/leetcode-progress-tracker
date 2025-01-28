class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> List=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }
        
        int j=i+1;
        int k=nums.length-1;
        while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>0){
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    List.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(nums[j]==nums[j-1] && j<k){
                       j++; 
                    }
                    
                }
            }
        }
        return List;
       }
        
        
    }
