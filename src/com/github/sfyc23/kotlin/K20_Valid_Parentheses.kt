package com.github.sfyc23.kotlin

import java.util.Stack

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/#/description
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 *
 * 给定一个仅包含字符'（'，'）'，'{'，'}'，'['和']'的字符串，确定输入字符串是否有效。
 *
 *
 * 括号必须以正确的顺序关闭，“（）”和“（）[] {}”都是有效的，但“（]”和“（[）]”不是。
 * ( = 40 { =123 [ = 91
 * ) = 41 } =125 ] = 93
 */
object K20_Valid_Parentheses {
    @JvmStatic fun main(args: Array<String>) {
        //        System.out.println(isValid("([])[]"));
        //        System.out.println(isValid("{}{}()[]"));

        println(isValid2("[[]]()()"))
        println(isValid2("[(])(())"))

    }

    /**
     * 使用 stack 后入先出（LIFO）集合

     * @param s
     * *
     * @return
     */
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            when (c) {
                '(' -> stack.push(')')
                '{' -> stack.push('}')
                '[' -> stack.push(']')
                else -> if (stack.isEmpty() || stack.pop() !== c) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }

    fun isValid2(s: String): Boolean {
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            when (c) {
                '(' -> stack.add(')')
                '{' -> stack.add('}')
                '[' -> stack.add(']')
                else -> {
                    if (stack.isEmpty()) {
                        return false
                    }
                    val cc = stack[stack.size - 1]
                    if (cc != c) {
                        return false
                    }
                    stack.removeAt(stack.size - 1)
                }
            }
        }
        return stack.isEmpty()
    }


}
