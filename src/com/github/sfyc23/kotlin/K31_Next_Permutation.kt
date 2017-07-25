package com.github.sfyc23.kotlin

import java.util.Arrays

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/#/description
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 *
 * 思路：
 * 123的排序是：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 * next_permutation 函数将按字母表顺序生成给定序列的下一个较大的排列，直到整个序列为降序为止
 * 归纳分析这个过程：
 * 假设 m 个元素的序列 pn，下一组较大排列是 pn+1
 * 1.若 pn 最后两个元素构成一个最小的增序序列，直接反转最后两个元素得到 pn+1
 * 2.若后面最多 s 个元素构成了一个减序子集
 * 令 i = m -s，保证 i 之前的元素不动
 * 在 (i+1)–m 这些元素中，遭到仅次于但大于第 i 个元素，交换这两个元素
 * 此时只要得到新子集{pn(i+1), pn(i+2), …, pn(i), …,pn(m)}的最小排列即可
 * 注意到新子集仍保持减序，那么直接将其反转即可得到最小的增序子集。


 */
object K31_Next_Permutation {
    @JvmStatic fun main(args: Array<String>) {

        nextPermutation(intArrayOf(1, 2, 4, 3))
        nextPermutation(intArrayOf(1, 1))
    }

    /**
     * 倒车

     * @param nums
     */
    fun nextPermutation(nums: IntArray) {
        var left = 0;
        var temp = 0;
        var right = 0;
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        }

        if (left > 0) {
            for (i in left + 1..nums.lastIndex) {
                if (nums[i - 1] > nums[i]) {
                    right = i;
                    break;
                }
            }
            temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }

        right = nums.lastIndex;
        left = left + 1;
        if (left < right) {
            temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
        }
        println(Arrays.toString(nums))
    }


}
