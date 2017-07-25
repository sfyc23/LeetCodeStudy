package com.github.sfyc23.kotlin

import java.util.Stack

/**
 * 32. Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/#/description
 *
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 *
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 *
 *
 * 有效最长长度,"()(()", = 2;
 *
 *
 * ()(()
 * ()(()) = 6;
 * (()(()(
 */
object K32_Longest_Valid_Parentheses {
    @JvmStatic fun main(args: Array<String>) {
        println(longestValidParentheses02("()(()"))

        println(longestValidParentheses("())()()"))
    }

    fun longestValidParentheses(s: String?): Int {
        if (s == null || s.length < 2) {
            return 0;
        }
        var longest = 0;
        var last = -1;
        var stack: Stack<Int> = Stack()

        s.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(index)
            } else if (stack.isEmpty()) {
                last = index
            } else {
                stack.pop()
                if (stack.isEmpty()) {
                    longest = Math.max(longest, index - last);
                } else {
                    longest = Math.max(longest, index - stack[stack.lastIndex]);
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
    fun longestValidParentheses02(s: String): Int {
        val S = s.toCharArray()
        val V = IntArray(S.size)
        var open = 0
        var max = 0
        for (i in S.indices) {
            if (S[i] == '(') {
                open++
            }
            if (S[i] == ')' && open > 0) {
                // matches found
                V[i] = 2 + V[i - 1]
                // add matches from previous
                if (i - V[i] > 0) {
                    V[i] += V[i - V[i]]
                }
                open--
            }
            max = Math.max(max, V[i])
        }
        return max
    }
}
