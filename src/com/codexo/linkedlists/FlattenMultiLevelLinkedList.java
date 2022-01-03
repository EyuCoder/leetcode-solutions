package com.codexo.linkedlists;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class FlattenMultiLevelLinkedList {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(1) constant
     */
    public static Node flatten(Node head) {
        if (head == null) return null;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.child == null) {
                currentNode = currentNode.next;
            } else {
                Node tail = currentNode.child;
                while (tail.next != null) {
                    tail = tail.next;
                }

                tail.next = currentNode.next;
                if (tail.next != null) {
                    tail.next.prev = tail;
                }

                currentNode.next = currentNode.child;
                currentNode.next.prev = currentNode;
                currentNode.child = null;
            }
        }

        return head;
    }

    public static void printList(Node node) {
        System.out.print("HEAD -> ");
        while (node != null) {
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node node = new Node(1,
                new Node(2),
                        new Node(7),
                                new Node(3));
        // Optimal solution
        printList(flatten(node));
    }
}
