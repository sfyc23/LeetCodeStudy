package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/#/description
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class J22_Generate_Parentheses {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }


    public static List<String> generateParenthesis(int n) {
        List<String> parentheses = new ArrayList<>();
        if (n <= 0) {
            return parentheses;
        }
        backtrack(parentheses,"", 0, 0, n);
        return parentheses;
    }

    public static void backtrack(List<String> pss, String str, int left, int right, int n) {
        if (str.length() == 2 * n) {
            pss.add(str);
            return;
        }

        if (left < n) {
            backtrack(pss, str+"(", left + 1, right, n);
        }

        if (right < left) {
            backtrack(pss, str+")", left, right + 1, n);
        }

    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

}
