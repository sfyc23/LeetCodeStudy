package com.github.sfyc23.java;


import java.math.BigDecimal;

/**
 * 166. Fraction to Recurring Decimal
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal/#/description
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 Credits:
 Special thanks to @Shangrila for adding this problem and creating all test cases.

 两整数相除只能等于 无限循环小数
 关键在于判断小数中，循环的数字为多少
 */
public class J166_Fraction_to_Recurring_Decimal {
    public static void main(String[] args) {
        fractionToDecimal(12,745454545);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        Double dNumeratord = Double.valueOf(numerator);
        Double dDenominator = Double.valueOf(denominator);


        Double dFraction = dNumeratord / dDenominator;
        System.out.println(dFraction);
        System.out.println(dFraction.toString().length());

        BigDecimal bn = new BigDecimal(dNumeratord);
        BigDecimal dd = new BigDecimal(dNumeratord);
        Double dF = dNumeratord / dDenominator;
        System.out.println(dF);

        return null;

    }
}
