import java.util.*;

class Solution {
    int n;
    Map<Integer, Integer> map = new HashMap<>();
    int[][] dp = new int[2001][2001];

    public boolean canCross(int[] stones) {
        n = stones.length;
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        for (int i = 0; i < n; i++) {
            map.put(stones[i], i);
        }

        return frog(0, 0, stones);
    }

    public boolean frog(int currind, int prevjump, int[] stones) {
        if (currind == n - 1) {
            return true;
        }

        if (dp[currind][prevjump] != -1) {
            return dp[currind][prevjump] == 1;
        }

        for (int nxtjump = prevjump - 1; nxtjump <= prevjump + 1; nxtjump++) {
            if (nxtjump > 0) {
                int nextstone = stones[currind] + nxtjump;

                if (nextstone > stones[n - 1]) break;

                if (map.containsKey(nextstone)) {
                    if (frog(map.get(nextstone), nxtjump, stones)) {
                        dp[currind][prevjump] = 1;
                        return true;
                    }
                }
            }
        }

        dp[currind][prevjump] = 0; 
        return false;
    }
}
