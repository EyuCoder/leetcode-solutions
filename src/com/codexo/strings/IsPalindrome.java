package com.codexo.strings;

import java.util.Stack;

public class IsPalindrome {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    static boolean isPalindromeBrute(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c);
            }
        }
        System.out.println(stack);
        for (int i = stack.size() - 1, j = 0; i >= 0; i--) {
            if (stack.get(i) != stack.get(j)) {
                return false;
            }
            j++;
        }
        return true;
    }

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) Constant
     */
    static boolean isPalindromeOptimal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        // Brute force solution using @Stack
        System.out.println(isPalindromeBrute("A man, a plan, a canal: Panama")); //true
        System.out.println(isPalindromeBrute("race a car")); //false

        // Optimal solution using 2 pointers technic
        System.out.println(isPalindromeOptimal("A man, a plan, a canal: Panama")); //true
        System.out.println(isPalindromeOptimal("race a car")); //false
    }
}
