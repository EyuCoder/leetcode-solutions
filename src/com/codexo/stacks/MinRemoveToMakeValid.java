package com.codexo.stacks;

import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
public class MinRemoveToMakeValid {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static String minRemoveToMakeValid(String s) {
        StringBuilder builder = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '(') {
                stack.push(i);
            } else if (builder.charAt(i) == ')') {
                if (!stack.empty()) stack.pop();
                else builder.setCharAt(i, ' ');
            }
        }

        while (!stack.empty()) builder.setCharAt(stack.pop(), ' ');
        return builder.toString().replaceAll(" ", "");
    }

    public static void main(String[] args) {
        String result = minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(result); // "lee(t(c)o)de"
        result = minRemoveToMakeValid("a)b(c)d");
        System.out.println(result); // "ab(c)d"
        result = minRemoveToMakeValid("\"))((\"");
        System.out.println(result); // ""
    }
}
