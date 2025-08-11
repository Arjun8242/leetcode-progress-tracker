class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] pse=getpse(arr);
        int[] nse=getnse(arr);
        int maxarea=0;
        for(int i=0;i<n;i++){
            int right=nse[i];
            int left=pse[i];
            int width=right-left-1;
            int area=arr[i]*width;
            maxarea=Math.max(maxarea,area);
        }
            return maxarea;        
    }
    public static int[] getnse(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
            return nse;
    }
    public static int[] getpse(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            pse[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
            return pse;
    }
}