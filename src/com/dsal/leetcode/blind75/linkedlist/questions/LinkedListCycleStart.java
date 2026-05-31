package com.dsal.leetcode.blind75.linkedlist.questions;

public class LinkedListCycleStart {

    // https://leetcode.com/problems/linked-list-cycle-ii/submissions/2015718055/

    private static ListNode linkedListCycleStart(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                fast = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
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


        System.out.println("LinkedList cycle start == " +  (linkedListCycleStart(head)));

        head.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start == " + (linkedListCycleStart(head)).value);

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }
}
