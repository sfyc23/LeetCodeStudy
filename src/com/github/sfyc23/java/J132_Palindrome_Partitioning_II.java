package com.github.sfyc23.java;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 132. Palindrome Partitioning II
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
 *
 * "ababababababababababababcbabababababababababababa"
 */
public class J132_Palindrome_Partitioning_II {

    public static void main(String[] args) {
        System.out.println(minCut("ababababac"));
    }

    public static int minCut(String s) {
        Stack<Integer> stack = new Stack<>();
        backtrack(stack, new ArrayList<>(), s,0);
        return stack.pop();
    }

    private static void backtrack(Stack<Integer> stack, List<String> tempList, String s,int start) {
        int len = s.length();
        if (len == start) {
            int minlength = 0;
            if (stack.isEmpty()) {
                minlength = tempList.size() - 1;
            } else {
                minlength = Math.min(stack.pop(), tempList.size() - 1);
            }
            stack.push(minlength);
            return;
        }
        for (int i = start-1; i >= 0; i++) {
            String sub = s.substring(start, i + 1);
            if (!isPalindrome(sub)) {
                continue;
            }

            tempList.add(sub);
            backtrack(stack, tempList, s,i+1);
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
