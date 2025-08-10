class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long mod=1_000_000_007L;
        int[] nse=getnse(arr);
        int[] pse=getpse(arr);
        long tot=0;

        for(int i=0;i<n;i++){
            long right=nse[i]-i;
            long left=i-pse[i];
            tot=(tot+(long)right*left*arr[i])%mod;
        }
        return (int)tot;
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
}