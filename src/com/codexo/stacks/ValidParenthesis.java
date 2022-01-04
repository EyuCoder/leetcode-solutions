package com.codexo.stacks;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses
public class ValidParenthesis {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static boolean isValid(String s) {
        if (s.length() / 2 == 0) return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') stack.push(c);
            else if (stack.empty()) return false;
            else if (c == '}' && stack.pop() != '{') return false;
            else if (c == ')' && stack.pop() != '(') return false;
            else if (c == ']' && stack.pop() != '[') return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        boolean result = isValid("()[]{}");
        System.out.println(result); //true
        result = isValid("()[");
        System.out.println(result); //false
    }
}
