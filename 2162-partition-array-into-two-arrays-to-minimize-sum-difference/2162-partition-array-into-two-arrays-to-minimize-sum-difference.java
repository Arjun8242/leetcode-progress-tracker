class Solution {
    /*public int minimumDifference(int[] arr) {
        int n=arr.length;
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        boolean[][] dp = new boolean[n][totSum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0]<= totSum) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }*/
    // this code is good but will not run for negative values in input so using diffeerent approach "meet in the middle" this approach utilizes binary search to solve//
    public int solve(List<Integer> sum1, List<Integer> sum2, int tot) {
        int m = sum1.size(), n = sum2.size();
        int minDiff = Integer.MAX_VALUE;
        Collections.sort(sum2);

        for (int i = 0; i < m; i++) {
            int target = tot / 2 - sum1.get(i);
            int lb = lowerBound(sum2, target);

            if (lb == n) {
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (sum1.get(i) + sum2.get(n - 1))));
            } else if (lb == 0) {
                minDiff = Math.min(minDiff, Math.abs(tot - 2 * (sum1.get(i) + sum2.get(0))));
            } else {
                minDiff = Math.min(minDiff, Math.min(
                        Math.abs(tot - 2 * (sum1.get(i) + sum2.get(lb))),
                        Math.abs(tot - 2 * (sum1.get(i) + sum2.get(lb - 1)))
                ));
            }
        }

        return minDiff;
    }

    public int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int tot = 0;

        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
            nums2[i] = nums[i + n];
            tot += nums1[i] + nums2[i];
        }

        List<Integer>[] sum1 = new ArrayList[n + 1];
        List<Integer>[] sum2 = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            sum1[i] = new ArrayList<>();
            sum2[i] = new ArrayList<>();
        }

        for (int mask = 0; mask < (1 << n); mask++) {
            int tot1 = 0, tot2 = 0, count = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    tot1 += nums1[j];
                    tot2 += nums2[j];
                    count++;
                }
            }
            sum1[count].add(tot1);
            sum2[count].add(tot2);
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            minDiff = Math.min(minDiff, solve(sum1[i], sum2[n - i], tot));
        }

        return minDiff;
    }
}