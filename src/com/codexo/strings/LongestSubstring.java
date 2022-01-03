package com.codexo.strings;


import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    /**
     * Time Complexity: O(n^2) Quadratic
     * Space Complexity: O(n) Linear
     */
    public static int longestSubstringBrute(String s) {
        if (s.length() <= 1) return s.length();
        int longest = 1, n = s.length();

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int counter = 1;
            for (int j = i + 1; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                counter++;
                set.add(s.charAt(j));
                longest = Math.max(longest, counter);
            }
        }
        return longest;
    }

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static int longestSubstringOptimal(String s) {
        int longest = 0, left = 0;
        int[] cache = new int[128];
        for (int right = 0; right < s.length(); right++) {
            if(cache[s.charAt(right)] > 0) {
                left = Math.max(left, cache[s.charAt(right)]);
            }
            cache[s.charAt(right)] = right + 1;
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        //brute force Solution using for loop
        int result = longestSubstringBrute("abcabcbb");
        System.out.println(result); //3
        result = longestSubstringBrute("");
        System.out.println(result); //0

        //Optimal Solution using sliding window technic
        result = longestSubstringOptimal("abcabcbb");
        System.out.println(result); //3
        result = longestSubstringOptimal("");
        System.out.println(result); //0
    }
}
