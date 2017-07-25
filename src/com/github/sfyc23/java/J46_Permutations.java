package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/#/description
 * <p>
 * 46. Permutations
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 不同数据
 */
public class J46_Permutations {
    public static void main(String[] args) {

//        System.out.println(permute(new int[]{1, 2, 3}));

//        System.out.println(permute02(new int[]{0,1, 2}));
        System.out.println(permute02(new int[]{1, 2, 3, 4, 5}));

    }


    //------------------------------第一种方法--------------------------
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permuteAdd(listList, list, nums);
        return listList;
    }


    public static void permuteAdd(List<List<Integer>> listList, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            listList.add(list);
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                List<Integer> l = new ArrayList<>();
                l.addAll(list);
                l.add(num);
                permuteAdd(listList, l, nums);
            }
        }
    }
    //------------------------------end 第一种方法 end--------------------------


    //------------------------------第二种方法--------------------------
    public static List<List<Integer>> permute02(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Boolean[] used = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }

        permuteAdd02(listList, list, used, nums);
        return listList;
    }


    public static void permuteAdd02(List<List<Integer>> listList, List<Integer> list, Boolean[] used, int[] nums) {
        if (list.size() == nums.length) {
            listList.add(list);
            System.out.println(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                List<Integer> l = new ArrayList<>();
                l.addAll(list);
                l.add(nums[i]);
//                list.add(nums[i]);
                permuteAdd02(listList, l, used, nums);

                used[i] = false;
//                list.remove(list.size() - 1);
            }
        }

    }


}
