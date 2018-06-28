package com.github.sfyc23.java;

import java.util.Arrays;
import java.util.List;

/**
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 */
public class J139_Word_Break {

    public static void main(String[] args) {

//        List<String> list = Arrays.asList(new String[]{"leet", "code"});
//        String s = "leetcode";

        List<String> list = Arrays.asList(new String[]{"a"});
        String s = "aloveyou";
        System.out.println(wordBreak(s, list));

        System.out.println(s.substring(5));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String sub = s.substring(i, j);
                if (dp[i] && wordDict.contains(sub)) {
                    dp[j] = true;
                }
            }
        }

        return dp[len];
    }

}
