class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] dp = new int[budget + 1];

        int minPrice = Integer.MAX_VALUE;
        int[] free = new int[n];

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int price = items[i][1];

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j],
                    dp[j - price] + free[i] + 1);
            }
        }

        int ans = 0;

        for (int j = 0; j <= budget; j++) {
            ans = Math.max(ans,
                dp[j] + (budget - j) / minPrice);
        }

        return ans;
        
    }
}