package com.codexo.linkedlists;

// https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedListII {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int currentPos = 0;
        ListNode currentNode = head;
        ListNode start = head;

        while (currentPos < left) {
            start = currentNode;
            currentNode = currentNode.next;
            currentPos++;
        }

        ListNode newList = null, tail = currentNode;

        while (currentPos >= left && currentPos <= right) {
            ListNode next = currentNode.next;
            currentNode.next = newList;
            newList = currentNode;
            currentNode = next;
            currentPos++;
        }

        start.next = newList;
        tail.next = currentNode;

        if (left > 1) {
            return head;
        } else {
            return newList;
        }
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
        ListNode listNode = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        // Optimal solution
        printList(listNode);
        printList(reverseBetween(listNode, 2, 4));
    }
}
