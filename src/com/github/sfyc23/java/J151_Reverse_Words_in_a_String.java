package com.github.sfyc23.java;

/**
 * 151. Reverse Words in a String
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Update (2015-02-12):
 * For C programmers: Try to solve it in-place in O(1) space.
 */
public class J151_Reverse_Words_in_a_String {


    public static void main(String[] args) {
        System.out.println(reverseWords02("a"));

    }

    public static String reverseWords02(String s) {

        StringBuilder addSb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                tempSb.append(s.charAt(i));
            } else {
                if (tempSb.length() > 0) {
                    addSb.append(tempSb.reverse().toString()).append(" ");
                    tempSb.setLength(0);
                }
            }
        }
        if (tempSb.length() > 0) {
            addSb.append(tempSb.reverse().toString());
            tempSb.setLength(0);
        }

        if (addSb.length() > 0) {
            return addSb.toString().trim();
        }
        return "";
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        if (words == null && words.length <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].trim().length() != 0) {
                sb.append(words[i]).append(" ");
            }

        }

        if (sb.length() >= 1) {
            return sb.substring(0, sb.length() - 1);
        }

        return "";

    }
}
