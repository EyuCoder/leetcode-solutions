package com.codexo.linkedlists;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

    Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    Node(int val, Node next, Node prev, Node child) {
        this.val = val;
        this.next = next;
        this.prev = prev;
        this.child = child;
    }
}