package com.github.sfyc23.kotlin

import java.util.*

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/#/description
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
object K15_3Sum {

    @JvmStatic fun main(args: Array<String>) {
        var ints = intArrayOf(-1, 0, 1, 2, -1, -4)
        threeSum(ints)
    }

    fun threeSum(nums: IntArray?): List<List<Int>>? {
        val intss = ArrayList<List<Int>>()
        if (nums == null || nums.size < 3) {
            return intss
        }

        nums.sort()

        for (i in 0..nums.size - 2 - 1) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var j = i + 1
            var k = nums.size - 1
            val num = -nums[i]
            while (j < k) {
                when {
                    nums[j] + nums[k]==num ->{
                        intss.add(Arrays.asList(nums[i], nums[j], nums[k]))
                        j++
                        k--
                        while (j < k && nums[j] == nums[j - 1]) {
                            j++
                        }

                        while (j < k && nums[k] == nums[k + 1]) {
                            k--
                        }
                    }
                    nums[j] + nums[k] < num -> j++
                    nums[j] + nums[k] > num -> k--
                }
            }

        }
        return intss
    }


}
