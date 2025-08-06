class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        int len=num.length();
        
        for(int i=0;i<len;i++){
            char ch=num.charAt(i);
            while(!stack.isEmpty() && k>0 && stack.peek()>ch){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(k-->0){
            stack.pop();
        }

        StringBuilder sb=new StringBuilder();
        for(char c:stack) sb.append(c);

        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        return sb.length()==0?"0":sb.toString();
    }
}