class Solution {
    public int minOperations(String s) {
        int n=s.length();

        char[] arr=s.toCharArray();
        char[] sorted=s.toCharArray();
        Arrays.sort(sorted);
        String target=new String(sorted);

        if(s.equals(target)) return 0;
        if(n==2) return -1;

        if(s.charAt(0)==target.charAt(0) || s.charAt(n-1)==target.charAt(n-1)) return 1;

        Arrays.sort(arr, 0, n-1);
        Arrays.sort(arr, 1, n);
        
        if(new String(arr).equals(target)) return 2;

        arr=s.toCharArray();

        Arrays.sort(arr, 1, n);
        Arrays.sort(arr, 0, n-1);
        
        if(new String(arr).equals(target)) return 2;

        return 3;
    }
}