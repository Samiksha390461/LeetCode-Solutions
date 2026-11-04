class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long leftSum = 0, rightSum = 0;
    int leftSize = 0, rightSize = 0;

    void addLeft(int val) {
        left.put(val, left.getOrDefault(val, 0) + 1);
        leftSum += val;
        leftSize++;
    }

    void addRight(int val) {
        right.put(val, right.getOrDefault(val, 0) + 1);
        rightSum += val;
        rightSize++;
    }

    void removeLeft(int val) {
        int count = left.get(val);
        if (count == 1) left.remove(val);
        else left.put(val, count - 1);

        leftSum -= val;
        leftSize--;
    }

    void removeRight(int val) {
        int count = right.get(val);
        if (count == 1) right.remove(val);
        else right.put(val, count - 1);

        rightSum -= val;
        rightSize--;
    }

    void balance() {
        int target = (leftSize + rightSize + 1) / 2;

        while (leftSize > target) {
            int val = left.lastKey();
            removeLeft(val);
            addRight(val);
        }

        while (leftSize < target) {
            int val = right.firstKey();
            removeRight(val);
            addLeft(val);
        }
    }

    void insert(int val) {
        if (left.isEmpty() || val <= left.lastKey()) {
            addLeft(val);
        } else {
            addRight(val);
        }
        balance();
    }

    void erase(int val) {
        if (left.containsKey(val)) {
            removeLeft(val);
        } else {
            removeRight(val);
        }
        balance();
    }

    long getCost() {
        long median = left.lastKey();

        return median * leftSize - leftSum
                + rightSum - median * rightSize;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] maritovexi = nums;

        long[] cost = new long[n - x + 1];

        for (int i = 0; i < x; i++) {
            insert(maritovexi[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {
            erase(maritovexi[i - x]);
            insert(maritovexi[i]);

            cost[i - x + 1] = getCost();
        }

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 1; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int t = 1; t <= k; t++) {

            for (int i = 1; i <= n; i++) {

                dp[t][i] = dp[t][i - 1];

                if (i >= x && dp[t - 1][i - x] != INF) {

                    dp[t][i] = Math.min(
                        dp[t][i],
                        dp[t - 1][i - x] + cost[i - x]
                    );
                }
            }
        }

        return dp[k][n];
        
    }
}