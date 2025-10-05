class Solution {
    public boolean helper(char[][] board, String word, int idx, int r, int c) {
        if (idx == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
                board[r][c] != word.charAt(idx)) {
            return false;
        }
        char temp = board[r][c];
        if (temp == word.charAt(idx)) {
            
            board[r][c] = '#';

            boolean found = helper(board, word, idx + 1, r + 1, c) ||
                    helper(board, word, idx + 1, r - 1, c) ||
                    helper(board, word, idx + 1, r, c + 1) ||
                    helper(board, word, idx + 1, r, c - 1);

            board[r][c] = temp;

            return found;
        }
        else{
            return false;
        }

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
