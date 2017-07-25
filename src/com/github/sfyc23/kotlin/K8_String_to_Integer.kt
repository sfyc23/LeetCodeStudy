package com.github.sfyc23.kotlin

/**
 * https://leetcode.com/problems/string-to-integer-atoi/#/description
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
object K8_String_to_Integer {
    @JvmStatic fun main(args: Array<String>) {
        println(myAtoi("010"))

        println(myAtoi("2147483647"))

    }

    fun myAtoi(str: String?): Int? {
        str?.let {
            return it.toIntOrNull()
        }
        return null;
    }
}
