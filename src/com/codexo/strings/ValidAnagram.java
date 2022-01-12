package com.codexo.strings;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] table = new int[128];

        for(int c : s.toCharArray())table[c]++;

        for(int c : t.toCharArray()){
            table[c]--;
            if(table[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car")); // false
    }
}
