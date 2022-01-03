package com.codexo.linkedlists;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycle {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static boolean hasCycle(ListNode head) {
        ListNode hare = head, tortoise = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        // Optimal solution using Floyd's Tortoise And Hare Algorithm
        System.out.println(hasCycle(listNode));
    }
}
