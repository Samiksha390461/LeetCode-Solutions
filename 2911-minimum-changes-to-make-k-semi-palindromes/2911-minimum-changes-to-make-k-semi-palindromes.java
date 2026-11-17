class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Calculate cost for every substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                cost[i][j] = len;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int cnt = 0;

                    for (int x = 0; x < d; x++) {
                        int l = i + x;
                        int r = j - d + 1 + x;

                        while (l < r) {
                            if (s.charAt(l) != s.charAt(r)) {
                                cnt++;
                            }
                            l += d;
                            r -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], cnt);
                }
            }
        }

        // DP
        int INF = 1000000;
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }

        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                for (int end = i + 1; end < n; end++) {
                    if (dp[end + 1][j - 1] != INF) {
                        dp[i][j] = Math.min(
                            dp[i][j],
                            cost[i][end] + dp[end + 1][j - 1]
                        );
                    }
                }
            }
        }

        return dp[0][k];
        
    }
}