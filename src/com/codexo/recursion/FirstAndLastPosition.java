package com.codexo.recursion;


import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosition {

    /**
     * Time Complexity: O(log n) Logarithmic
     * Space Complexity: O(1) constant
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        // using Binary Search
        int[] result = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(result)); // [3,4]
        result = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(result)); // [-1,-1]
    }
}
