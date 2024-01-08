class Solution {
    public boolean exist(char[][] board, String word) {
        boolean start;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start = helper(board, word, i, j, 0);
                if (start) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        // if out of bounds or the char doesn't match the char in the string
        if (!(0 <= i && i < board.length && 0 <= j && j < board[0].length) || board[i][j] != word.charAt(index)) {
            return false;
        }
        char holder = board[i][j];
        board[i][j] = '.';
        boolean cont =
            helper(board, word, i + 1, j, index + 1) || 
            helper(board, word, i - 1, j, index + 1) || 
            helper(board, word, i, j + 1, index + 1) || 
            helper(board, word, i, j - 1, index + 1);
        board[i][j] = holder;
        return cont;
    }
}