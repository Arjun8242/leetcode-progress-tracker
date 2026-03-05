class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int prevind=stack.pop();
                ans[prevind]=i-prevind;
            }
            stack.push(i);
        }
        return ans;
    }
}