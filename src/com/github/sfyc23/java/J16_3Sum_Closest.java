package com.github.sfyc23.java;

import java.util.Arrays;

/*
16. 3Sum Closest
https://leetcode.com/problems/3sum-closest/#/description
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

   For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class J16_3Sum_Closest {
    public static void main(String[] args) {
//        assertEquals(new int[]{-1, 2, 1 ,- 4}, 1, 2);
//
//        assertEquals(new int[]{1, 1, 1, 0}, 100, 2);

//        assertEquals(new int[]{-3,-2,-5,3,-4}, -1, 2);

        assertEquals(new int[]{0, 2, 1, -3}, 1, 0);
    }


    public static boolean assertEquals(int[] nums, int target, int expected) {
        System.out.println(threeSumClosest(nums, target));

        return false;
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                if (tempSum == target) {
                    return tempSum;
                } else if (tempSum < target) {
                    j++;
                } else {
                    k--;
                }
                if (Math.abs(tempSum - target) < Math.abs(result - target)) {
                    result = tempSum;
                }

            }
        }

        return result;
    }
}
