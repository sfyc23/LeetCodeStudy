package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/#/description
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 * <p>
 * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
 */
public class J60_Permutation_Sequence {
    public static void main(String[] args) {
        getPermutation(5, 15);
    }

    public static String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        // create a list of numbers to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }

        // numbers = {1, 2, 3, 4}
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial;
            sb.append(numbers.get(index));
            numbers.remove(index);
            if (i > 0) {
                k %= factorial;
                factorial /= i;
            }

        }
        return sb.toString();
    }


}
