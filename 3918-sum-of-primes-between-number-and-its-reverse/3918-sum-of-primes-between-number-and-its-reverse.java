class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev=rev(n);
        int sum=0;

        for(int i=Math.min(n, rev);i<=Math.max(rev, n);i++){

            if(i<2) continue;
            
            int flag = 1;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                sum += i;
            }
        }
        return sum;
    }

    public int rev(int n){
        int rev=0;
        while(n>0){
            int r=n%10;
            rev=rev*10+r;
            n/=10;
        }
        return rev;
    }
}