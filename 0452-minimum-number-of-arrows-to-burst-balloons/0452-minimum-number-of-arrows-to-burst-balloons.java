class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            int start=points[i][0];
            int end=points[i][1];

            while(i+1<n && points[i+1][0]<=end){
                end=Math.min(end, points[i+1][1]);
                i++;
            }
            result.add(new int[] {start,end});
        }
        return result.size();
    }
}