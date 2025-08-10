class Solution {
    public long subArrayRanges(int[] nums) {

      return sumSubarrayMax(nums) - sumSubarrayMin(nums);

    }

    public long sumSubarrayMin(int[] nums) {
        int n = nums.length;
        int[] pse = getPSE(nums);
        int[] nse = getNSE(nums);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += (long) nums[i] * left * right;
        }
        return sum;
    }

    public long sumSubarrayMax(int[] nums) {
        int n = nums.length;
        int[] pge = getPGE(nums); 
        int[] nge = getNGE(nums);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += (long) nums[i] * left * right;
        }
        return sum;
    }

    // Monotonic Stack 

    public int[] getPSE(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public int[] getNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public int[] getPGE(int[] nums) {
        int n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    public int[] getNGE(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return nge;
    }
}