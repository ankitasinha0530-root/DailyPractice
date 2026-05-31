package com.dsal.leetcode.blind75.linkedlist.questions;

public class LinkedListCycleLength {

    // https://leetcode.com/problems/linked-list-cycle/submissions/2015659776/

    private static int linkedListCycleLength(ListNode head) {

       if(head == null){
           if(head.next == null) {
               return 1;
           }
           return 0;
       }

       int count = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                count = 1;
                do {
                    slow = slow.next;
                    count++;
                }while (slow != fast);
                return count;
            }
        }
        return count;
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


        System.out.println("LinkedList cycle loop count == " +  linkedListCycleLength(head));

        head.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle loop count  == " + linkedListCycleLength(head));

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }
}
