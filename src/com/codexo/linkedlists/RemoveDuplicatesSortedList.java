package com.codexo.linkedlists;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
public class RemoveDuplicatesSortedList {

    /**
     * ->Sentinel Node<-
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) Constant
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }

            head = head.next;
        }
        return sentinel.next;
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
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(4,
                                                        new ListNode(5, null)))))));

        // Optimal solution Using Sentinel Node
        printList(listNode);
        printList(deleteDuplicates(listNode)); // 1 -> 2 -> 5
    }
}
