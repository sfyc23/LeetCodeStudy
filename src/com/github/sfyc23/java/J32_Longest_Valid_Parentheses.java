package com.github.sfyc23.java;

import scala.Int;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/#/description
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * <p>
 * 有效最长长度,"()(()", = 2;
 * <p>
 * ()(()
 * ()(()) = 6;
 * (()(()(
 */
public class J32_Longest_Valid_Parentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses02("()(()"));

        System.out.println(longestValidParentheses("()(()()"));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int longest = 0;
        int last = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (stack.isEmpty()) {
                last = i;
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    longest = Math.max(longest, i - last);
                } else {
                    longest = Math.max(longest, i - stack.get(stack.size() - 1));
                }
            }
        }
        return longest;
    }

    /*

      *
 * ()(()
 * ()(()) = 6;
 * (()(()(
 */
    public static int longestValidParentheses02(String s) {
        char[] S = s.toCharArray();
        int[] V = new int[S.length];
        int open = 0;
        int max = 0;
        for (int i = 0; i < S.length; i++) {
            if (S[i] == '(') {
                open++;
            }
            if (S[i] == ')' && open > 0) {
                // matches found
                V[i] = 2 + V[i - 1];
                // add matches from previous
                if (i - V[i] > 0) {
                    V[i] += V[i - V[i]];
                }
                open--;
            }
            max = Math.max(max, V[i]);
        }
        return max;
    }
}
