package com.github.sfyc23.kotlin

import java.util.ArrayList

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/#/description
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 *
 * Note: Given n will be between 1 and 9 inclusive.

 * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
 */
object K60_Permutation_Sequence {
    @JvmStatic fun main(args: Array<String>) {
        getPermutation(5, 15)
    }

    fun getPermutation(n: Int, k: Int): String {
        var k = k-1;

        val numbers = arrayListOf<Int>();
        for (i in 1..n) {
            numbers.add(i);
        }

        var factorial = 1;
        for (i in n - 1 downTo 1) {
            factorial *= i;
        }

        val sb = StringBuilder()
        for (i in n - 1 downTo 0) {
            var index = k / factorial
            sb.append(numbers[index])
            numbers.removeAt(index)
            if (i > 0) {
                k %= factorial
                factorial /= i
            }
        }

        println(sb.toString())
        return sb.toString()
    }


}
