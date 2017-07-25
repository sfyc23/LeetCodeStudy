package com.github.sfyc23.kotlin

import java.util.HashMap


fun main(args: Array<String>) {

}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        val complement = target - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map.put(nums[i], i)
    }
    throw IllegalArgumentException("No two sum solution")
}


