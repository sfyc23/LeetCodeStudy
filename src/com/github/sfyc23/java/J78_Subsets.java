package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 * Given a set of distinct integers, nums, return all possible subsets.
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * If nums = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class J78_Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subSetStep(result, new ArrayList<>(), nums, i, 0);
        }

        return result;
    }

    public static void subSetStep(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int count, int start) {
        if (count == start) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            subSetStep(lists, tempList, nums, count, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
