class Solution {
    public boolean isValid(String s) {
        int len=s.length();
        Stack<Character> stack=new Stack<>();
        /*for(int i=0;i<len;i++){
            char ind=s.charAt(i);
            if(ind=='(' || ind=='{' || ind=='[') stack.push(ind);
            if(ind==')' || ind=='}' || ind==']'){
                if(stack.isEmpty()) return false;
                if(stack.peek()=='(' && ind!=')')return false;
                if(stack.peek()=='{' && ind!='}')return false;
                if(stack.peek()=='[' && ind!=']')return false;
                else stack.pop();
            }
        }
        
        return stack.isEmpty();
*/



        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(c==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                }
                else if(c=='}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }
                else if(c==']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}