package com.codexo.arrays;

// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static int findPeakElementBrute(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    /**
     * Time Complexity: O(log n) logarithmic
     * Space Complexity: O(1) constant
     */
    public static int findPeakElementOptimal(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        // O(n) by traversing the array
        int result = findPeakElementBrute(new int[]{1,2,3,1});
        System.out.println(result); // index 2
        result = findPeakElementBrute(new int[]{1,2,1,3,5,6,4});
        System.out.println(result); // index 5 or 1

        // Optimal solution using Binary Search
        result = findPeakElementOptimal(new int[]{1,2,3,1});
        System.out.println(result); // index 2
        result = findPeakElementOptimal(new int[]{1,2,1,3,5,6,4});
        System.out.println(result); // index 5 or 1
    }
}
