package com.codexo.linkedlists;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {

    /**
     * Time Complexity: O(n) Linear
     * Space Complexity: O(n) Linear
     */
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        Set<ListNode> map = new HashSet<>();

        ListNode current = head;
        while(current!=null){
            map.add(current);
            if(map.contains(current.next)){
                return current.next;
            }
            current = current.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3,
                new ListNode(2,
                        new ListNode(0,null)));

        System.out.println(detectCycle(listNode));
    }
}
