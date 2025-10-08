#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int n;
    unordered_map<int, int> mp;
    int dp[2001][2001];

    bool frog(int currind, int prevjump, vector<int>& stones) {
        if (currind == n - 1) {
            return true;
        }
        if (dp[currind][prevjump] != -1) {
            return dp[currind][prevjump] == 1;
        }

        bool res = false;

        for (int nxtjump = prevjump - 1; nxtjump <= prevjump + 1; nxtjump++) {
            if (nxtjump > 0) {
                int nextstone = nxtjump + stones[currind];
                if (mp.find(nextstone) != mp.end()) {
                    res = res || frog(mp[nextstone], nxtjump, stones);
                }
            }
        }

        dp[currind][prevjump] = res ? 1 : 0; 
        return res;
    }

    bool canCross(vector<int>& stones) {
        n = stones.size();

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            mp[stones[i]] = i;
        }

        return frog(0, 0, stones);
    }
};
