package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 34. Search for a Range
 * https://leetcode.com/problems/search-for-a-range/#/description
 * <p>
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */
public class J34_Search_for_a_Range {
    public static void main(String[] args) {

        //[1],1,  Expected:[0,0]

        int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {

        List<Integer> list = new ArrayList<>();

        int start = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
//                start = i;
                length++;
                list.add(i);
                while (i < nums.length - 1 && nums[i + 1] == target) {
                    i++;
                }
                list.add(i);
                break;
            }
        }

        if (list.size() == 0) {
            return new int[]{-1, -1};
        }


        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
