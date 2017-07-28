package com.github.sfyc23.kotlin



import java.util.ArrayList
import java.util.Arrays

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 *
 * Each number in C may only be used once in the combination.
 *
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
object K40_Combination_Sum_II {

    @JvmStatic fun main(args: Array<String>) {

        println(combinationSum(intArrayOf(10, 1, 2, 7, 6, 1, 5, 2), 8))

    }

    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val list = ArrayList<List<Int>>()
        nums.sort()
        backtrack(list, ArrayList<Int>(), nums, target, 0)
        return list
    }

    private fun backtrack(list: MutableList<List<Int>>, tempList: MutableList<Int>, nums: IntArray, target: Int, start: Int) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            list.add(ArrayList(tempList))
            return
        }
        for (i in start..nums.size - 1) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue
            }
            tempList.add(nums[i])
            backtrack(list, tempList, nums, target - nums[i], i + 1)
            tempList.removeAt(tempList.size - 1)
        }

    }
}
