package com.github.sfyc23.java;


import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.
 */
public class J212_Word_Search_II {


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i==1&&j==2){
                    break;
                }
                System.out.println("i = "+i+" , j = "+j);
            }
            System.out.println("i = "+i);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {

        int verLength = board.length;
        int horLength = board[0].length;

        List<String> result = new ArrayList<>();

        boolean isJumpLoop = false;

        for (String word : words) {

            isJumpLoop = false;
            boolean[][] dp = new boolean[verLength][horLength];
            for (int i = 0; i < verLength; i++) {
                if (isJumpLoop) {
                    break;
                }
                for (int j = 0; j < horLength; j++) {
                    char c = word.charAt(0);
                    if (c == board[i][j]) {

                        dp[i][j] = true;
                        if (loopFind(result,board, dp, word, verLength, horLength, 1, i, j)) {
                            isJumpLoop = true;
                            break;
                        }
                        dp[i][j] = false;
                    }
                }
            }
        }

        return result;
    }


    public static boolean loopFind(List<String> list,char[][] board, boolean[][] dp, String word, int verLength, int horLength, int wStart, int i, int j) {
        if (wStart == word.length()) {
            list.add(word);
            return true;
        }

        if (i + 1 < verLength && !dp[i + 1][j] && board[i + 1][j] == word.charAt(wStart)) {
            dp[i + 1][j] = true;
            if (loopFind(list,board, dp, word, verLength, horLength, wStart + 1, i + 1, j)) {
                return true;
            }
            dp[i + 1][j] = false;
        }

        if (j + 1 < horLength && !dp[i][j + 1] && board[i][j + 1] == word.charAt(wStart)) {
            dp[i][j + 1] = true;
            if (loopFind(list,board, dp, word, verLength, horLength, wStart + 1, i, j + 1)) {
                return true;
            }
            dp[i][j + 1] = false;
        }

        if (i - 1 >= 0 && !dp[i - 1][j] && board[i - 1][j] == word.charAt(wStart)) {
            dp[i - 1][j] = true;
            if (loopFind(list,board, dp, word, verLength, horLength, wStart + 1, i - 1, j)) {
                return true;
            }
            dp[i - 1][j] = false;
        }

        if (j - 1 >= 0 && !dp[i][j - 1] && board[i][j - 1] == word.charAt(wStart)) {
            dp[i][j - 1] = true;
            if (loopFind(list,board, dp, word, verLength, horLength, wStart + 1, i, j - 1)) {
                return true;
            }
            dp[i][j - 1] = false;
        }

        return false;
    }
}
