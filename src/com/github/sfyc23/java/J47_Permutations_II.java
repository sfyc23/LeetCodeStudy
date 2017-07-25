package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [
 [1,1,2],
 [1,2,1],
 [2,1,1]
 ]
 */
public class J47_Permutations_II {
    public static void main(String[] args) {


        System.out.println(permuteUnique(new int[]{3, 1, 3,3}));

    }

    //------------------------------第二种方法--------------------------
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Boolean[] used = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        Arrays.sort(nums);
        permuteAdd02(listList, list, used, nums);
        return listList;
    }


    public static void permuteAdd02(List<List<Integer>> listList, List<Integer> list, Boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            listList.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {

                continue;
            }
            used[i] = true;
            List<Integer> l = new ArrayList<>();
            l.addAll(list);
            l.add(nums[i]);
            permuteAdd02(listList, l, used, nums);

            used[i] = false;
        }

    }
}
