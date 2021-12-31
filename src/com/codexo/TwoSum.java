package com.codexo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum {

    /**
     * Time Complexity: O(n^2) Quadratic
     * Space Complexity: O(1) constant
     */
    public static int[] twoSumBrute(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int item = 0; item < nums.length; item++) {
            if (map.containsKey(nums[item])) {
                return new int[]{map.get(nums[item]), item};
            } else {
                map.put(target - nums[item], item);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        //brute force Solution using Nested loop
        int[] result = twoSumBrute(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));
        result = twoSumBrute(new int[]{}, 2);
        System.out.println(Arrays.toString(result));

        //Optimal Solution using @HashMap
        result = twoSumOptimal(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(result));
        result = twoSumOptimal(new int[]{}, 2);
        System.out.println(Arrays.toString(result));
    }
}