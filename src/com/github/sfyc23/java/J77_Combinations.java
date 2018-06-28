package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/tabs/description
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class J77_Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(result, new ArrayList<>(), nums, k, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int k, int start) {

        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }
}
