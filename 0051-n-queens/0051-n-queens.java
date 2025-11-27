class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, board, col, diag1, diag2, result, n);
        return result;
    }

    private void backtrack(int row, char[][] board, boolean[] col, boolean[] diag1,
                           boolean[] diag2, List<List<String>> result, int n) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) {
                temp.add(new String(r));
            }
            result.add(temp);
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row + c;              // major diagonal
            int d2 = row - c + n;          // minor diagonal

            if (col[c] || diag1[d1] || diag2[d2])
                continue;

            board[row][c] = 'Q';
            col[c] = diag1[d1] = diag2[d2] = true;

            backtrack(row + 1, board, col, diag1, diag2, result, n);

            board[row][c] = '.';
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}
