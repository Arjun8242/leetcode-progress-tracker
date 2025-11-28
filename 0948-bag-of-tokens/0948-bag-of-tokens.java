class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left=0;
        int right=tokens.length-1;
        int score=0;
        int maxscore=0;

        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                left++;
                score++;
            }
            else if(score>=1){
                power+=tokens[right];
                right--;
                score--;
            }
            else {
                break;
            }
            maxscore=Math.max(score, maxscore);
        }
        return maxscore;
    }
}