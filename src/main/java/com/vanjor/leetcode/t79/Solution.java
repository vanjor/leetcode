package com.vanjor.leetcode.t79;

/**
 *  medium
 *  problem: word-search https://leetcode.com/problems/word-search/
 *  time: taking 4+ hours for mistaking array.clone should be shallow clone
 *  performance: O(n) time, O(n) space , >97% Java
 *  method: dic & recursive
 */
public class Solution implements SolutionInterface {

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) {
            return false;
        }
        boolean[][] mark = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ( seek(board, word, mark, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // NOTICE: first time try using array.clone to copy, then found multiple dimension array clone is shallow clone.
    //         which lead to error result, push me found the way using only one mark array.
    public boolean seek(char[][] board, String word, boolean[][] mark, int offset, int i, int j) {

        if (board[i][j] != word.charAt(offset) || mark[i][j]) {
            return false;
        } else if (word.length() == offset + 1) {
            return true;
        } else {
            mark[i][j] = true;
        }

        char currentChar = word.charAt(offset + 1);
        boolean result = false;

        if (!result && i > 0 && board[i - 1][j] == currentChar && !mark[i - 1][j]) {
            result = seek(board, word, mark, offset + 1, i - 1, j);
            if (!result) {
                mark[i - 1][j] = false;
            }
        }
        if (!result && i + 1 < mark.length && board[i + 1][j] == currentChar && !mark[i + 1][j]) {
            result = seek(board, word, mark, offset + 1, i + 1, j);
            if (!result) {
                mark[i + 1][j] = false;
            }
        }

        if (!result && j > 0 && board[i][j - 1] == currentChar && !mark[i][j - 1]) {
            result = seek(board, word, mark, offset + 1, i, j - 1);
            if (!result) {
                mark[i][j - 1] = false;
            }
        }

        if (!result && j + 1 < mark[0].length && board[i][j + 1] == currentChar && !mark[i][j + 1]) {
            result = seek(board, word, mark, offset + 1, i, j + 1);
            if (!result) {
                mark[i][j + 1] = false;
            }
        }

        if (!result) {
            mark[i][j] = false;
        }

        return result;
    }
}
