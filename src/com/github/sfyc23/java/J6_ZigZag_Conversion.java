package com.github.sfyc23.java;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 */
public class J6_ZigZag_Conversion {
    public static void main(String[] args) {
        checkEquals("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR");
        checkEquals("AB", 1, "AB");
        checkEquals("ABCD", 2, "ACBD");



    }

    public static void checkEquals(String s, int numRows, String expected) {
        String output = convert02(s, numRows);
        if (!output.equals(expected)) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("error : input:" + s + " , output:" + output + " , expected:" + expected);
            System.out.println("-----------------------------------------------------------------");
        } else {
            System.out.println("sucess : input:" + s + " , output:" + output);
        }
    }


    public static String convert02(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) { // vertically down
                sb[idx].append(c[i++]);
            }
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {// obliquely up
                sb[idx].append(c[i++]);
            }
        }

        for (int idx = 1; idx < sb.length; idx++) {
            sb[0].append(sb[idx]);

        }

        return sb[0].toString();
    }



}
