package com.github.sfyc23.java;

import sun.misc.FloatingDecimal;

/**
 * 65. Valid Number
 * Validate if a given string is numeric.
 * <p>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class J65_Valid_Number {

    public static void main(String[] args) {
//        System.out.println(Double.parseDouble(" +.8 "));
//        System.out.println(Double.parseDouble("46e.3"));//false
        System.out.println(Double.parseDouble(".e1"));

//        System.out.println(isNumber("2e0"));
//        System.out.println(isNumber(". 1"));
//        System.out.println(isNumber("-1."));
        System.out.println(isNumber("3."));
    }

    public static boolean isNumber(String s) {

        s = s.trim();
        int len = s.length();
        if (len == 0) {
            return false;
        }

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

}
