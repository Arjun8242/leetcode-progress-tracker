class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long totpdt=1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            totpdt=nums[i]*totpdt;
        }
        if(target==0 || totpdt!=target*target){
            return false;
        }
        Map<String,Boolean> Memo=new HashMap<>();
        return memoization(0,target,nums,Memo);
    }
    boolean memoization(int ind, long target,int[] nums, Map<String,Boolean> Memo){
        if(ind==nums.length) return false;
        if(target==1) return true;
        String key = ind + "_" + target;
        if (Memo.containsKey(key)) return Memo.get(key);
        boolean pick=false;
        if(target%nums[ind]==0){
        pick=memoization(ind+1,target/nums[ind],nums,Memo);
        }
        boolean notpick=memoization(ind+1,target,nums,Memo);
        boolean result=pick|| notpick;
        Memo.put(key, result);
        return result;
    }
}