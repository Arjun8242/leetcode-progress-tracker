class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        // int ans=Integer.MAX_VALUE;
        
        // for(int k=0;k<=n;k++){
        //     int deletions=0;

        //     for(int i=0;i<k;i++){
        //         if(s.charAt(i)=='b') deletions++;
        //     }

        //     for(int i=k;i<n;i++){
        //         if(s.charAt(i)=='a') deletions++;
        //     }

        //     ans=Math.min(ans, deletions);
        // }
        // return ans;
        int bCount = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                deletions = Math.min(deletions + 1, bCount);
            }
        }
        return deletions;
    }
}