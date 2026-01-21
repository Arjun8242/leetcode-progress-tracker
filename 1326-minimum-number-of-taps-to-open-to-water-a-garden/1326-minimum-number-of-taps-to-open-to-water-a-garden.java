class Solution {
    public int minTaps(int n, int[] ranges) {
        List<int[]> range=new ArrayList<>();

        for(int i=0;i<=n;i++){
            int r=ranges[i];

            if(r==0) continue;
            
            int left=i-r;
            int right=i+r;

            if(left<right){
                range.add(new int[]{left, right});
            }
        }

        if(range.isEmpty()) return -1;

        range.sort((a, b) -> {
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        });

        List<int[]> newRefinedRange=new ArrayList<>();

        for(int i=0;i<range.size();i++){
            int[] curr=range.get(i);

            while(i+1<range.size() && range.get(i+1)[0]==curr[0]){
                i++;
            }
            newRefinedRange.add(curr);
        }

        int taps=0;
        int currEnd=0;
        int nextEnd=0;
        int i=0;

        while(currEnd<n){
            while(i<newRefinedRange.size() && newRefinedRange.get(i)[0]<=currEnd){
                nextEnd=Math.max(nextEnd, newRefinedRange.get(i)[1]);
                i++;
            }

            if(currEnd==nextEnd) return -1;

            taps++;
            currEnd=nextEnd;
        }

        return taps;
    }
}