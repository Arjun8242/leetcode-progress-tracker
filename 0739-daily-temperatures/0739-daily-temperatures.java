class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[temperatures.length];
        for(int i=0;i<res.length;i++){

            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])       {
                  int prevind=stack.pop();
                  res[prevind]=i-prevind;
            }
            stack.push(i);
        }
        return res;
    }
}