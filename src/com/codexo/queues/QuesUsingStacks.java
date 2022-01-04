package com.codexo.queues;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks
public class QuesUsingStacks {

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(43);
        System.out.println("pop: " + obj.pop());
        System.out.println("peak: " + obj.peek());
        System.out.println("empty: " + obj.empty());
    }
}

class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    // O(1)
    public void push(int x) {
        if (s1.empty())
            front = x;
        s1.push(x);
    }

    // O(1)
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        return s2.pop();
    }

    // O(1)
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    // O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
