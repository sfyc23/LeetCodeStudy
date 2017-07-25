package com.github.sfyc23.java;

/*
https://leetcode.com/problems/palindrome-number/#/description
Determine whether an integer is a palindrome. Do this without extra space.

负数不是回文数
个位数是回文数
1.将整数转成字符串
2.将整数反转,判断是否==
 */
public class J9_Palindrome_Number {
    public static void main(String[] args) {
//        checkEquals(-218, false);
//        checkEquals(-2147483648, false);
//        checkEquals(-21812, false);
        checkEquals(2147447412, false);

    }

    public static void checkEquals(int s, Boolean expected) {
        Boolean output = isPalindrome2(s);

//        if (expected == output) {
//            System.out.println("-------------------------------------------------------------");
//            System.err.println("error:input:" + s + " , output:" + output + " , expected:" + expected);
//            System.out.println("-------------------------------------------------------------");
//        } else {
//            System.out.println("sucess:input:" + s + " , output:" + output);
//        }
    }


    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
            System.out.println(x + " , rev = " + rev);
        }
//        System.out.println(x + " , rev = " + rev);

        return (x == rev || x == rev / 10);
    }


    public static Boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);

        int length = str.length();
        if (length <= 1) {
            return true;
        }
        int n = 0;
        int m = length - 1;
        while (n < m) {
            System.out.println(str.charAt(n) + ",n = " + str.charAt(m));
            if (str.charAt(n++) != str.charAt(m--)) {
                return false;
            }
        }
        return true;
    }

}
