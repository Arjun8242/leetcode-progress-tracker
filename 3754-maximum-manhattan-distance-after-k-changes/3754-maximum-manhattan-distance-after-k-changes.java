class Solution {
    public int maxDistance(String S, int k) {
        int len=S.length();
        int n=0;
        int w=0;
        int s=0;
        int e=0;
        int maxdis=0;
        for(int i=0;i<len;i++){
            if(S.charAt(i)=='N') n++;
            if(S.charAt(i)=='E') e++;
            if(S.charAt(i)=='W') w++;
            if(S.charAt(i)=='S') s++;
            int x=Math.abs(e-w);
            int y=Math.abs(n-s);
            int minimum_distance=x+y;
            int change=minimum_distance+Math.min(2*k,i+1-minimum_distance);
            maxdis=Math.max(maxdis,change);
        }
        return  maxdis;     
    }
}