class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, ans, n);
        return ans;
    }

    void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] row : board)
                list.add(new String(row));
            ans.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 'Q') return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;

        for (int i = row, j = col; i < n && j >= 0; i++, j--)
            if (board[i][j] == 'Q') return false;

        return true;

        
    }
}