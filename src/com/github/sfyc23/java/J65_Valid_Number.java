package com.github.sfyc23.java;

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
        System.out.println(Double.parseDouble(" 0.1 "));
    }

    public static boolean isNumber(String s) {

        try {
            double l = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }

//        return false;
    }

}
