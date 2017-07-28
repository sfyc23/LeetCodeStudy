package com.github.sfyc23.kotlin

import java.util.Stack

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/#/description
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 *
 * You may assume that the given expression is always valid.
 *
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 *
 * 括号并不影响计算
 *
 *

 *
 *
 * 括号前是减号  3-((5-6)-1)
 * 有多个括号。(3-(2-(5-(9-(4)))))
 * 括号里只有数字 (3-(2-(5-(9-(4)))))
 * 并非个位数
 */
object K224_Basic_Calculator {
    @JvmStatic fun main(args: Array<String>) {
        println(calculate("3-((5-6)-1)"))
    }

    //3-((5-6)-1)
    fun calculate(s: String): Int {


        val stack = Stack<Int>()
        var result = 0
        var number = 0
        var sign = 1
        s.forEach {
            when (it) {
                in '0'..'9' -> {
                    number = number * 10 + (it - '0')
                }
                '+' -> {
                    result += sign * number
                    sign = 1
                    number = 0
                }
                '-' -> {
                    result += sign * number
                    sign = -1
                    number = 0
                }
                '(' -> {
                    stack.push(result)
                    stack.push(sign)
                    sign = 1
                    result = 0
                }
                ')' -> {

                    result += sign * number

                    result *= stack.pop()
                    result += stack.pop()
                    number = 0
                }

                else -> {
                }
            }
        }

        if (number != 0) {
            result += sign * number
        }

        return result
    }


}
