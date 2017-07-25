package com.github.sfyc23.java;


import java.util.Arrays;

/**
 * 567. Permutation in String
 * https://leetcode.com/problems/permutation-in-string/#/description
 * <p>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
public class J456_Permutation_in_String {
    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "dccddcba"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return false;
        }
        if (s2 == null || s2.length() < s1.length()) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();

        int[] count = new int[128];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i)]--;
        }

        for (int r = 0, L = 0; r < len2; r++) {
            if (++count[s2.charAt(r)] > 0) {
                while (--count[s2.charAt(L++)] != 0) {
                }
            } else if (r - L + 1 == len1) {
                return true;
            }
        }

        return false;
    }




    public static boolean checkInclusion02(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return false;
        }
        if (s2 == null || s2.length() < s1.length()) {
            return false;
        }

        int[] count = new int[24];

        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (isZero(count)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (isZero(count)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isZero(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
