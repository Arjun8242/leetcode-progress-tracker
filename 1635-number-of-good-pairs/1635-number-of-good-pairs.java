class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        /*for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    pairs++;
                }
            }
        }*/ 

        HashMap<Integer,Integer> pairs=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(pairs.containsKey(nums[i])){
                count+=pairs.get(nums[i]);
            }
            pairs.put(nums[i],pairs.getOrDefault(nums[i],0)+1);
        }
        return count;
    }
}