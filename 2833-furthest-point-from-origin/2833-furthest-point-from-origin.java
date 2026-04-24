class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int count=0;
        int n=moves.length();
        int Rs=0;
        int Ls=0;

        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L') Ls++;

            else if(moves.charAt(i)=='R') Rs++;

            else count++;
        }

        return count+Math.abs(Rs-Ls);
    }
}