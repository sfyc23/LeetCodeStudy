package com.github.sfyc23.java;

/**
 * 44. Wildcard Matching
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false
 * <p>
 * //前一个字符串是正经的，后面的才有通配符。
 */
public class J44_Wildcard_Matching {

    public static void main(String[] args) {

        System.out.println(isMatch2("abb", "a*b"));//true
        System.out.println(isMatch2("abbbc", "*?b*"));//true
    }

    /**
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {


        int ls = s.length();
        int lp = p.length();
        if (ls == 0 || lp == 0) {
            return ls == 0 && lp == 0;
        }
        if (p.charAt(0) != '*') {
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
                return isMatch2(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            while (s.length() > 0) {
                if (isMatch2(s, p.substring(1))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch2(s, p.substring(1));
        }

//        return true;
    }


    public static boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*')
                break;
            else
                match[s.length()][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                    match[i][j] = match[i + 1][j + 1];
                else if (p.charAt(j) == '*')
                    match[i][j] = match[i + 1][j] || match[i][j + 1];
                else
                    match[i][j] = false;
            }
        }
        return match[0][0];
    }

}
