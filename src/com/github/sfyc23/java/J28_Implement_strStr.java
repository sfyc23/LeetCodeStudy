package com.github.sfyc23.java;

/**
 * https://leetcode.com/problems/implement-strstr/#/description
 * 28. Implement strStr()
 * Implement strStr().
 * <p>
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class J28_Implement_strStr {
    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
