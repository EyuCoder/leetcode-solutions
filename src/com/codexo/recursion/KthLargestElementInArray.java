package com.codexo.recursion;

// https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInArray {

    /**
     * Time Complexity: O(n^2) Quadratic (worst case)
     * Space Complexity: O(1) constant
     */
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        int count = high - pivot + 1;
        if (count == k) return nums[pivot];
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // using quickselect
        int result = findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(result); // 5
        result = findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(result); // 4
    }
}
