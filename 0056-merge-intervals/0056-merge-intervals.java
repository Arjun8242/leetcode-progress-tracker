class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        List<int[]> result=new ArrayList<>();

        int i=0;
        while(i<n){
            int start=intervals[i][0];
            int end=intervals[i][1];

            while(i+1<n && intervals[i+1][0]<=end){
                end=Math.max(end,intervals[i+1][1]);
                i++;
            }

            result.add(new int[]{start,end});
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}