package com.github.sfyc23.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 643. Maximum Average Subarray II
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * <p>
 * The answer with the calculation error less than 10-5 will be accepted.
 */
public class J644_Maximum_Average_Subarray_II {


    public static void main(String[] args) {
        int[] nums = new int[]{8, 9, 3, 1, 8, 3, 0, 6, 9, 2};

        System.out.println(findMaxAverage(nums, 8));

//        System.out.println(findMaxAverage(nums, 4));
    }


    //白痴做法
    public static double findMaxAverage(int[] nums, int k) {

        int maxNum = sum(nums, k - 1, k);
        int sum = maxNum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxNum = Math.max(sum, maxNum);
        }

        double average = maxNum / 1.0 / k;
        System.out.println(average);

        String sAverage = String.valueOf(average);
        if (sAverage.contains(".") && sAverage.length() - sAverage.indexOf('.') - 1 > 5) {
            int pos = sAverage.indexOf(".");
            average = Double.parseDouble(sAverage.substring(0, pos + 6));
            if (sAverage.charAt(pos + 6) - '0' >= 5) {
                average += 0.00001;
            }
        }

        return average;
    }

    public static int sum(int[] nums, int over, int k) {
        int sum = 0;
        while (k-- > 0) {
            sum += nums[over--];
        }
        return sum;
    }
}
