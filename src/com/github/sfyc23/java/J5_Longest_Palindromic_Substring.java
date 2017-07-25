package com.github.sfyc23.java;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/#/description
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 */
public class J5_Longest_Palindromic_Substring {
    public static void main(String[] args) {

        checkEquals("cbabad", "bab");
        checkEquals("cbbd", "bb");
        checkEquals("s", "s");
        checkEquals("bb", "bb");
        checkEquals("abcda", "a");

//        System.out.println(isPalindrome("abccccda"));

    }

    public static void checkEquals(String s, String expected) {
        String output = longestPalindrome05(s);
        if (!output.equals(expected)) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("input:" + s + " , output:" + output + " , expected:" + expected);
            System.out.println("-----------------------------------------------------------------");
        } else {
            System.out.println("input:" + s + " , output:" + output);
        }
    }

    /*
    Manacher 算法
     */
    public static String longestPalindrome05(String s) {

        char[] t = preprocess(s);

        int[] p = new int[t.length];
        int center = 0, right = 0;

        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            } else {
                p[i] = 0;
            }
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int maxLength = 0;
        int start = 0;
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > p[maxLength]) {
                maxLength = i;
                start = (maxLength - 1 - p[maxLength]) / 2;
            }
        }

        return s.substring(start, start + p[maxLength]);
    }


    private static char[] preprocess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }


    /**
     * 动态规划法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome04(String s) {

        System.out.println("s = " + s);

        int length = s.length();
        int startIndex = 0;
        int maxLength = 1;
        Boolean[][] A = new Boolean[length][length];

        //单个字符一定是回文
        for (int i = 0, j = 0; i < length; i++, j++)
            A[i][j] = true;

//        printlnDoubleArray(A);

        //判断两个字符是否为回文
        for (int i = 0, j = i + 1; j < length; i++, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                A[i][j] = true;
                startIndex = i;
                maxLength = 2;
            }
        }

//        printlnDoubleArray(A);

        //判断3个以为以上是否为回文
        for (int k = 3; k <= length; k++) {
            for (int i = 0, j = k - 1; j < length; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    A[i][j] = A[i + 1][j - 1];
                    if (A[i][j] != null && A[i][j]) {
                        if (k > maxLength) {
                            startIndex = i;
                            maxLength = k;
                        }
                    }
                }
            }
        }
//        printlnDoubleArray(A);
        System.out.println("startIndex = " + startIndex + " , maxLength = " + maxLength);

        return s.substring(startIndex, startIndex + maxLength);

    }


    //反转世界
    public static String longestPalindrome03(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        String re = sb.reverse().toString();
        int maxLength = 0;
        String request = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (re.contains(temp)) {
//                    System.out.println("s = " + s + " , re = " + re + " , temp = " + temp);
                    if (j - i > maxLength) {
                        maxLength = j - i;
                        request = temp;
                    }
                }
            }
        }

        return request;
    }


    /**
     * 从中心向两边靠拢
     *
     * @param s
     * @return
     */
    public static String longestPalindrome02(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//奇数
            int len2 = expandAroundCenter(s, i, i + 1);//偶数
//            System.out.println("i = " + i + ", len1:" + len1 + " , len2:" + len2);
            int len = Math.max(len1, len2);

            if (len > end - start) {
//                if (len % 2 == 1) {
//                    start = i - len / 2;
//                    end = i + len / 2 + 1;
//                }
//                if (len % 2 == 0) {
//                    start = i - len / 2 + 1;
//                    end = i + len / 2 + 1;
//                }
                start = i - (len - 1) / 2;
                end = i + len / 2 + 1;
            }

        }
//        System.out.println("s = " + s + ", start:" + start + " , end:" + end);
        return s.substring(start, end);
    }


    public static int expandAroundCenter(String s, int left, int right) {
        int length = s.length();
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    /**
     * 传统迭代
     *
     * @param s
     * @return
     */
    public static String longestPalindrome01(String s) {
        if (s.length() == 1) {
            return s;
        }
        String result = "";
        int maxLong = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length; j++) {
                String temp = s.substring(i, j + 1);

                if (isPalindrome(temp)) {
                    System.out.println("temp = " + temp);
                    int len = j - i + 1;
                    if (maxLong < len) {
                        result = temp;
                        maxLong = len;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int m = s.length() - 1;
        int n = 0;
        while (n < m) {
            if (s.charAt(n++) != s.charAt(m--)) {
                return false;
            }
        }
        return true;
    }

    public static void printlnDoubleArray(Object[][] oo) {

        for (int i = 0; i < oo.length; i++) {
            for (int j = 0; j < oo[i].length; j++) {
                System.out.println("i = " + i + " , j = " + j + ", value = " + oo[i][j]);
            }
        }

    }
}
