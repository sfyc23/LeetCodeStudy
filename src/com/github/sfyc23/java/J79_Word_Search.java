package com.github.sfyc23.java;

/**
 * 79. Word Search
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * For example,
 * Given board =
 * <p>
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class J79_Word_Search {

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word = "ABCCED";


     /*   char[][] board = new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}
        };
        String word = "AAB";*/

  /*      char[][] board = new char[][]{
                {'a', 'b'}
        };
        String word = "ba";*/


        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int verLength = board.length;
        int horLength = board[0].length;
        boolean[][] dp = new boolean[verLength][horLength];

        for (int i = 0; i < verLength; i++) {
            for (int j = 0; j < horLength; j++) {
                char c = word.charAt(0);
                if (c == board[i][j]) {

                    dp[i][j] = true;
                    if (loopFind(board, dp, word, verLength, horLength, 1, i, j)) {
                        return true;
                    }
                    dp[i][j] = false;
                }
            }
        }
        return false;
    }

    public static boolean loopFind(char[][] board, boolean[][] dp, String word, int verLength, int horLength, int wStart, int i, int j) {
        if (wStart == word.length()) {
            return true;
        }

        if (i + 1 < verLength && !dp[i + 1][j] && board[i + 1][j] == word.charAt(wStart)) {
            dp[i + 1][j] = true;
            if (loopFind(board, dp, word, verLength, horLength, wStart + 1, i + 1, j)) {
                return true;
            }
            dp[i + 1][j] = false;
        }

        if (j + 1 < horLength && !dp[i][j + 1] && board[i][j + 1] == word.charAt(wStart)) {
            dp[i][j + 1] = true;
            if (loopFind(board, dp, word, verLength, horLength, wStart + 1, i, j + 1)) {
                return true;
            }
            dp[i][j + 1] = false;
        }

        if (i - 1 >= 0 && !dp[i - 1][j] && board[i - 1][j] == word.charAt(wStart)) {
            dp[i - 1][j] = true;
            if (loopFind(board, dp, word, verLength, horLength, wStart + 1, i - 1, j)) {
                return true;
            }
            dp[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !dp[i][j - 1] && board[i][j - 1] == word.charAt(wStart)) {
            dp[i][j - 1] = true;
            if (loopFind(board, dp, word, verLength, horLength, wStart + 1, i, j - 1)) {
                return true;
            }
            dp[i][j - 1] = false;
        }

        return false;
    }
}
