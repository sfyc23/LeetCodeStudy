package com.github.sfyc23.kotlin

/*
https://leetcode.com/problems/palindrome-number/#/description
Determine whether an integer is a palindrome. Do this without extra space.

负数不是回文数
个位数是回文数
将整数转成字符串
 */
object K9_Palindrome_Number {
    @JvmStatic fun main(args: Array<String>) {
        //        checkEquals(-218, false);
        //        checkEquals(-2147483648, false);
        //        checkEquals(-21812, false);
//        checkEquals(-2147447412, false)

        println(isPalindrome02(214412));

    }

    fun checkEquals(s: Int, expected: Boolean?) {
        val output = isPalindrome(s)

        if (expected === output) {
            println("-------------------------------------------------------------")
            System.err.println("error:input:$s , output:$output , expected:$expected")
            println("-------------------------------------------------------------")
        } else {
            println("sucess:input:$s , output:$output")
        }
    }

    fun isPalindrome02(x: Int): Boolean {
        if (x < 0 || (x >= 0 && x / 10 == 0)) return false
        var reverse = 0

        var x1 = x;

        while (reverse < x1) {
            reverse = reverse * 10 + x1 % 10
            x1 = x1 / 10;
            println("$x1, = "+reverse);
        }
//        println("$x, = "+reverse);
        return (x1 == reverse || x1 == reverse / 10);

    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        val str = x.toString()

        val length = str.length
        if (length <= 1) {
            return true
        }
        var n = 0
        var m = length - 1
        while (n < m) {
            if (str[n++] != str[m--]) {
                return false
            }
        }
        return true
    }

}
