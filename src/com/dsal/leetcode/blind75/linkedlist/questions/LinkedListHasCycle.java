package com.dsal.leetcode.blind75.linkedlist.questions;

public class LinkedListHasCycle {

    // https://leetcode.com/problems/linked-list-cycle/submissions/2015659776/

    private static boolean linkedListHasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){ // do not compare the value just compare the nodes
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        //Floyd's Loop detection algorithm is used with fast and slow pointers

        ListNode head ;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("LinkedList has a cycle == " + linkedListHasCycle(head));

        head.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has a cycle == " + linkedListHasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has a cycle == " + linkedListHasCycle(head));

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }
}
