package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note: The solution set must not contain duplicate subsets.

 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 */
public class J90_Subsets_II {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrack(result, new ArrayList<>(), nums, i, 0);
        }

        return result;
    }

    public static void backtrack(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int count, int start) {
        if (count == start) {
            lists.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(lists, tempList, nums, count, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
