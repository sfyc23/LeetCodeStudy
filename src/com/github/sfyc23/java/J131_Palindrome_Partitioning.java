package com.github.sfyc23.java;


import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class J131_Palindrome_Partitioning {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("caac"));
        System.out.println(partition("cbbca"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    private static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        int len = s.length();
        if (len <= start) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < len; i++) {
            String sub = s.substring(start, i + 1);
//            System.out.println("s = " + s + " , sub = " + sub + " ,i = " + i + " , len =" + len);

            if (!isPalindrome(sub)) {
                continue;
            }

            tempList.add(sub);
            backtrack(list, tempList, s, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        int len = s.length() - 1;
        int i = 0;
        while (i < len) {
            if (s.charAt(i++) != s.charAt(len--)) {
                return false;
            }
        }
        return true;
    }
}
