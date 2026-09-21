class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        solve(0, board, ans, n);
        return ans;
    }

    void solve(int row, char[][] board, List<List<String>> ans, int n) {

        if (row == n) {
            List<String> list = new ArrayList<>();

            for (char[] rowArr : board)
                list.add(new String(rowArr));

            ans.add(list);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (safe(board, row, col, n)) {
                board[row][col] = 'Q';

                solve(row + 1, board, ans, n);

                board[row][col] = '.';
            }
        }
    }

    boolean safe(char[][] board, int row, int col, int n) {

        // column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}