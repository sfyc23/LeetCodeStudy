package com.github.sfyc23.java;


import java.math.BigDecimal;
import java.util.HashMap;

/**
 * 166. Fraction to Recurring Decimal
 * <p>
 * https://leetcode.com/problems/fraction-to-recurring-decimal/#/description
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * For example,
 * <p>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Credits:
 * Special thanks to @Shangrila for adding this problem and creating all test cases.
 * <p>
 * 两整数相除只能等于 无限循环小数
 * 关键在于判断小数中，循环的数字为多少
 * <p>
 * <p>
 * remainder 余数
 * quotient 商数
 */
public class J166_Fraction_to_Recurring_Decimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1 , 6));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sb.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        long quo = num / den;
        long rem = num % den;

        //被整除
        if (rem == 0) {
            sb.append(quo);
            return sb.toString();
        }
        sb.append(quo).append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (rem != 0) {
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                return sb.insert(index,"(").append(")").toString();
            }
            map.put(rem, sb.length());
            rem *= 10;
            quo = rem / den;
            rem = rem % den;
            sb.append(quo);
        }

        return sb.toString();

    }
}
