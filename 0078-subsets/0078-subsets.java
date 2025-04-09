class Solution {
    public List<List<Integer>> subsets(int[] nums) {
          List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        recursion(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    void recursion(int[] nums, int ind, List<Integer> recursive,List<List<Integer>> ans){
       if(ind==nums.length){
        ans.add(new ArrayList<>(recursive));
        return;
       }
            recursive.add(nums[ind]);
            recursion(nums,ind+1,recursive,ans);
            recursive.remove(recursive.size()-1);
            recursion(nums,ind+1,recursive,ans);

        }


    }
    
