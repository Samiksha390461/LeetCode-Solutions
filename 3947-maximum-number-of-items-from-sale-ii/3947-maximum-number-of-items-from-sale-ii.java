class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int[] gain = new int[n + 1];

        int min = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            min = Math.min(min, item[1]);
        }

        // Precompute gain for every factor
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }
            gain[i]--;
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long ans = 0;
        long rem = budget;

        for (int[] item : items) {
            int price = item[1];
            int count = gain[item[0]];

            if (price >= 2L * min) break;
            if (count <= 0) continue;

            long take = Math.min(count, rem / price);

            ans += take * 2;
            rem -= take * price;
        }

        ans += rem / min;

        return (int) ans;
        
    }
}