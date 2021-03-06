package com.codexo.linkedlists;

// https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void printList(ListNode listNode) {
        System.out.print("HEAD -> ");
        while (listNode != null) {
            System.out.print(listNode.val);
            System.out.print(" -> ");
            listNode = listNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(54, null);
        ListNode node2 = new ListNode(23, node1);
        ListNode node3 = new ListNode(45, node2);

        // Optimal solution
        printList(node3);
        printList(reverseList(node3));
    }
}
