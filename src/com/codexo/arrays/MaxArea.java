package com.codexo.arrays;

//https://leetcode.com/problems/container-with-most-water/
public class MaxArea {

    /**
     * Time Complexity: O(n^2) Quadratic
     * Space Complexity: O(1) constant
     */
    public static int maxAreaBrute(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static int maxAreaOptimal(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (height[i] <= height[j]) {
                i++;
            } else j--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //brute force Solution using Nested loop
        int result = maxAreaBrute(new int[]{3, 2, 4});
        System.out.println(result);
        result = maxAreaBrute(new int[]{0});
        System.out.println(result);

        //Optimal Solution using Shifting pointers technic
        result = maxAreaOptimal(new int[]{3, 2, 4});
        System.out.println(result);
        result = maxAreaOptimal(new int[]{7});
        System.out.println(result);
    }
}
