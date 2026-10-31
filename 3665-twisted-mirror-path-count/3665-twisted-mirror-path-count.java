class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1_000_000_007;

        int[][] vornadexil = grid;

        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        if (n > 1) {
            right[0][1] = 1;
        }

        if (m > 1) {
            down[1][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (grid[i][j] == 1) {

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % mod;
                    }

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % mod;
                    }

                } else {

                    long ways = (right[i][j] + down[i][j]) % mod;

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + ways) % mod;
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + ways) % mod;
                    }
                }
            }
        }

        return (int) ((right[m - 1][n - 1]
                     + down[m - 1][n - 1]) % mod);

        
    }
}