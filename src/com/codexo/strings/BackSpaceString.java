package com.codexo.strings;

import java.util.Stack;

// https://leetcode.com/problems/backspace-string-compare/
public class BackSpaceString {

    /**
     * Time Complexity: O(s+t) Linear
     * Space Complexity: O(s+t) Linear
     */
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        Stack<Character> ans = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    /**
     * Time Complexity: O(s+t) Linear
     * Space Complexity: O(1) constant
     */
    public static boolean backspaceCompareOptimal(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }

            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        //brute force Solution using for loop
        boolean result = backspaceCompare("ab#c", "ad#c");
        System.out.println(result); //true
        result = backspaceCompare("a#c", "b");
        System.out.println(result); //false

        //Optimal Solution using two pointers
        result = backspaceCompareOptimal("ab#c", "ad#c");
        System.out.println(result); //true
        result = backspaceCompareOptimal("a#c", "b");
        System.out.println(result); //false
    }
}
