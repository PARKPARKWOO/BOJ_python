import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int a = 1000000007;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i: puddles) {
            dp[i[1]][i[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i - 1][j] > 0) dp[i][j] += dp[i - 1][j] % a;
                if (dp[i][j - 1] > 0) dp[i][j] += dp[i][j - 1] % a;
            }
        }
        return dp[n][m] % a;
    }
}