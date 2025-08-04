class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i:asteroids){
            if(i>0){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<-i){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek()<0) stack.push(i);

                if(stack.peek()==-i) stack.pop();
            }
        }

        int[] ans=new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}