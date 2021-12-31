package com.codexo.arrays;

//https://leetcode.com/problems/trapping-rain-water/
public class Trap {

    /**
     * Time Complexity: O(n^2) Quadratic
     * Space Complexity: O(1) constant
     */
    public static int trapBrute(int[] height) {
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int k = i; k < height.length; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            totalWater += Math.min(leftMax, rightMax) - height[i];
        }
        return totalWater;
    }

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static int trapOptimal(int[] height) {
        int left = 0, right = height.length - 1, totalWater = 0, maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else totalWater += maxLeft - height[left];
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else totalWater += maxRight - height[right];
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {

        //brute force Solution using Nested loop
        int result = trapBrute(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(result); // 6
        result = trapBrute(new int[]{0, 1, 0, 2});
        System.out.println(result); // 1

        //Optimal Solution using Shifting pointers' technic
        result = trapOptimal(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(result); // 6
        result = trapOptimal(new int[]{0, 1, 0, 2});
        System.out.println(result); // 1

    }
}
