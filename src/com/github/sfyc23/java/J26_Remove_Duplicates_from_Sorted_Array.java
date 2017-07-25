package com.github.sfyc23.java;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class J26_Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {

        int last = 0;
        for (int i = 1, length = nums.length; i < length; i++) {
            if (nums[last] != nums[i]) {
                last++;
                nums[last] = nums[i];
            }

        }
        return last + 1;
    }
}
