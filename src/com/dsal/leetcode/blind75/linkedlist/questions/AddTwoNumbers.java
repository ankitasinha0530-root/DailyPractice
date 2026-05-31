package com.dsal.leetcode.blind75.linkedlist.questions;

public class AddTwoNumbers {

    // Add Two Numbers (Java improved)
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.value : 0;
            int y = (l2 != null) ? l2.value : 0;

            int sum = carry + x + y;
            carry = sum / 10;  // to find the carried number

            // for carryover, since we have two digits so we want only single digit from 0 - 9 hence (sum % 10)
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

        //Floyd's Loop detection algorithm is used with fast and slow pointers

        ListNode head ;
        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);

        ListNode head2 ;
        head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        displayNode(addTwoNumbers(head, head2));

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }

    private static void displayNode(ListNode head){
        ListNode node = head;
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("END");
        System.out.println();
    }

}



/**

 1. Pick 1st element from both lists if they are not null
 2. add them with carry
 3, get carry after doing (sum / 10)
 4. save in new list by doing (sum % 10)

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
 
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]*/
