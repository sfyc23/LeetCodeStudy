package com.github.sfyc23.java;

import java.util.Arrays;

/**
 * 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/#/description
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p>
 * The replacement must be in-place, do not allocate extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 思路：
 * 123的排序是：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 * next_permutation 函数将按字母表顺序生成给定序列的下一个较大的排列，直到整个序列为降序为止
 * 归纳分析这个过程：
 * 假设 m 个元素的序列 pn，下一组较大排列是 pn+1
 * 1.若 pn 最后两个元素构成一个最小的增序序列，直接反转最后两个元素得到 pn+1
 * 2.若后面最多 s 个元素构成了一个减序子集
 * 令 i = m -s，保证 i 之前的元素不动
 * 在 (i+1)–m 这些元素中，遭到仅次于但大于第 i 个元素，交换这两个元素
 * 此时只要得到新子集{pn(i+1), pn(i+2), …, pn(i), …,pn(m)}的最小排列即可
 * 注意到新子集仍保持减序，那么直接将其反转即可得到最小的增序子集。
 *
 *
 */
public class J31_Next_Permutation {
    public static void main(String[] args) {
//        nextPermutation(new int[]{3, 4, 2, 1, 5, 6});
//        nextPermutation(new int[]{1, 2, 3});
//        nextPermutation02(new int[]{2, 1});


//        nextPermutation(new int[]{1, 1});
        nextPermutation(new int[]{1, 2, 4, 3});
        nextPermutation02(new int[]{1, 2, 4, 3});
    }

    /**
     * 倒车
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int len = nums.length,
                i = len - 1,
                j = len - 1,
                temp;

        // 找到减序子集的前一个元素，是 i-1
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        //  i > 0时，找到倒叙子集中的最大值-第j个元素
        if (i > 0) {
            while (nums[j] <= nums[i - 1]) {
                j--;
            }
            //  让第i-1个元素和第j个元素交换
            temp = nums[j];
            nums[j] = nums[i - 1];
            nums[i - 1] = temp;
        }

        // 倒置数组
        j = len - 1;
        while (i < j) {
            temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    正车
     */
    public static void nextPermutation02(int[] nums) {
        int k = -1;
        int l = 0;
        int temp = 0;

        for (int i = nums.length - 2; i > 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }

        //这个数组序列中的最后一个，
        if (k == -1) {
            //全部倒序
            k = 0;
            l = nums.length - 1;
            while (k < l) {
                temp = nums[k];
                nums[k] = nums[l];
                nums[l] = temp;
                k++;
                l--;
            }
            System.out.println(Arrays.toString(nums));
            return;
        }


        for (int i = k + 1; i < nums.length; i++) {
            if (nums[i] > nums[k]) {
                l = i;
            }
        }

        //置换从到 l,k
        temp = nums[k];
        nums[k] = nums[l];
        nums[l] = temp;

        l = nums.length - 1;
        k = k + 1;
        while (k < l) {
            temp = nums[k];
            nums[k] = nums[l];
            nums[l] = temp;
            k++;
            l--;
        }

        System.out.println(Arrays.toString(nums));

    }


}
