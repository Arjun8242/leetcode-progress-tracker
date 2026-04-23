class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long[] ans=new long[n];
        HashMap<Integer, List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> list : map.values()) {
            int size = list.size();

            long totalSum = 0;
            for (int idx : list) totalSum += idx;

            long leftSum = 0;

            for (int i = 0; i < size; i++) {
                int idx = list.get(i);

                long rightSum = totalSum - leftSum - idx;

                long left = (long) i * idx - leftSum;
                long right = rightSum - (long)(size - i - 1) * idx;

                ans[idx] = left + right;

                leftSum += idx;
            }
        }
        return ans;
    }
}