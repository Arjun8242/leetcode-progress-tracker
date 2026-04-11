class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> p : map.values()) {
            if (p.size() < 3) continue;
            for (int i = 0; i + 2 < p.size(); i++) {
                ans = Math.min(ans, 2 * (p.get(i + 2) - p.get(i)));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}