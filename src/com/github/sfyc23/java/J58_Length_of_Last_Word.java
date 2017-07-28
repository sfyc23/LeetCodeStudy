package com.github.sfyc23.java;

/**
 * 58. Length of Last Word
 */
public class J58_Length_of_Last_Word {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Helloworld"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int index = s.lastIndexOf(" ");
        if (index == -1) {
            return s.length();
        }
        return s.length() - index - 1;
//        return 0;
    }
}
