class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0 || visited[i][j])
                    continue;

                long sum = 0;

                java.util.Stack<int[]> stack = new java.util.Stack<>();

                stack.push(new int[]{i, j});
                visited[i][j] = true;

                while (!stack.isEmpty()) {

                    int[] cell = stack.pop();

                    int x = cell[0];
                    int y = cell[1];

                    sum += grid[x][y];

                    for (int d = 0; d < 4; d++) {

                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx >= 0 && nx < m &&
                            ny >= 0 && ny < n &&
                            grid[nx][ny] != 0 &&
                            !visited[nx][ny]) {

                            visited[nx][ny] = true;

                            stack.push(new int[]{nx, ny});
                        }
                    }
                }

                if (sum % k == 0)
                    count++;
            }
        }

        return count;
    }
}