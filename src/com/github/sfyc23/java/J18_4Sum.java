package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/#/description
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note: The solution set must not contain duplicate quadruplets.
 * <p>
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class J18_4Sum {
    public static void main(String[] args) {
//        int[] nums = { -1, 0, 1, 2, -1, -4};
        int[] nums = {1, 0, -1, 0, -2, 2};

        System.out.println(fourSum(nums, 0));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> intss = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return intss;
        }

        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i+1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = nums.length - 1;
                int num = target - nums[i] - nums[j];


                while (start < end) {
                    if (nums[start] + nums[end] == num) {
                        intss.add(Arrays.asList(nums[i],nums[j], nums[start], nums[end]));
                        start++;
                        end--;

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (nums[start] + nums[end] < num) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }


        }
        return intss;
    }

}
