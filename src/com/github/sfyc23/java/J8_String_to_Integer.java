package com.github.sfyc23.java;

import scala.Int;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/#/description
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * <p>
 * 需要判断的有
 * 首字母中
 * 1.负数（-）
 * 3.正数（-）
 * 2.空格
 * 4.前方为（0）
 *
 * 越界
 * 有非数字时，如果是首字母，则返回为空，如果是中间，则取前面的数字并返回
 */
public class J8_String_to_Integer {
    public static void main(String[] args) {
        checkEquals("3245", 3245);
//        checkEquals("010", 10);
//        checkEquals("  -0012a42", -12);
//        checkEquals("+-2", 0);
//        checkEquals("214748364558", 2147483647);


//        "  -0012a42"
    }


    public static void checkEquals(String s, int expected) {
        int output = myAtoi(s);
        if (expected != output) {
            System.out.println("-------------------------------------------------------------");
            System.err.println("error:input:" + s + " , output:" + output + " , expected:" + expected);
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("sucess:input:" + s + " , output:" + output);
        }
    }


    public static int myAtoi(String str) {
        if (null == str || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        int length = str.length();

        int start = 0;
        boolean isNegative = false;
        int limit;

        char firstChar = str.charAt(0);
        if (firstChar < '0') {  // Possible leading sign
            if (length == 1) {
                return 0;
            }
            start = 1;

            if (firstChar == '-') {
                isNegative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar == '+') {
                isNegative = false;
                limit = -Integer.MAX_VALUE;
            } else {
                return 0;
            }

        } else {
            start = 0;
            isNegative = false;
            limit = -Integer.MAX_VALUE;
        }


        int radix = 10;

        int limitBeforeMul = limit / radix;
        int result = 0;
        for (int i = start; i < length; i++) {
            int digit = Character.digit(str.charAt(i), radix);

            //不是数字时，输出为0
            if (digit < 0) {
                if (isNegative) {
                    return result;
                } else {
                    return -result;
                }
            }
//            if (result == 0 && digit == 0) {
//                break;
//            }
            if (result < limitBeforeMul) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            result *= radix;

            if (result < limit + digit) {

                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
//                return 0;
            }

            result -= digit;
        }

        if (isNegative) {
            return result;
        } else {
            return -result;
        }

    }
}
