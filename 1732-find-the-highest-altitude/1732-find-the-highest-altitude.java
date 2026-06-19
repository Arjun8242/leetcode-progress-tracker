class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int altitude=0;
        int maxaltitude=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            altitude+=gain[i];
            maxaltitude=Math.max(altitude, maxaltitude);
        }
        return maxaltitude<0?0:maxaltitude;
        
    }
}