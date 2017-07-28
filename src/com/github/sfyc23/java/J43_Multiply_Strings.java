package com.github.sfyc23.java;

/**
 * 43. Multiply Strings
 */
public class J43_Multiply_Strings {
    public static void main(String[] args) {
        System.out.println(multiply("0", "0"));
    }

    public static String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;

        int[] result = new int[len];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int n1 = Character.getNumericValue(num1.charAt(i));
                int n2 = Character.getNumericValue(num2.charAt(j));

                int product = n1 * n2;

                int curPos = i + j + 1;
                int prePos = curPos - 1;

                int cur = result[prePos] * 10 + result[curPos];
                product = product + cur;

                result[curPos] = product % 10;
                result[prePos] = product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            if (i == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(i);
        }

        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
