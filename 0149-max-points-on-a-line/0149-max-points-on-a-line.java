class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2) return n;//for 1,0 and 0,0 here 2 line will lie 

        int ans=0;

        for(int i=0;i<n;i++){
            Map<Double, Integer> map=new HashMap<>();
            int max=0;

            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];

                if(x1==x2 && y1==y2){
                    continue;
                }
                double slope;
                if(x1==x2){
                    slope=Double.POSITIVE_INFINITY;
                }
                else{
                    slope=(double)(y2-y1)/(x2-x1);
                    if(slope==-0.0) slope=0.0; //new java feature 🐸 for testcase [[2,3],[3,3],[-5,3]] expected=3
                    //output=2
                }
                map.put(slope, map.getOrDefault(slope,0)+1);
                max=Math.max(max, map.get(slope));
            }
            ans=Math.max(ans, max+1);
        }
        return ans;
    }
}