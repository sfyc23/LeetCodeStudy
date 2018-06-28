package com.github.sfyc23.java;

import java.util.Arrays;

/**
 * 75 Sort Colors
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class J75_Sort_Colors {

    public static void main(String[] args) {
        sortColors(new int[]{0, 0});
    }

    public static void sortColors(int[] nums) {
        int redIndex = 0;
        int blueIndex = nums.length - 1;
        for (int i = 0; i <= blueIndex; ) {
            if (nums[i] == 0) {
                if (nums[redIndex] != 0) {
                    swap(nums, redIndex, i);
                }
                redIndex++;
                i++;
            } else if (nums[i] == 2) {
                while (nums[blueIndex] == 2) {
                    if (blueIndex - 1 <= i) {
                        break;
                    }
                    blueIndex--;
                }
                swap(nums, i, blueIndex--);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
