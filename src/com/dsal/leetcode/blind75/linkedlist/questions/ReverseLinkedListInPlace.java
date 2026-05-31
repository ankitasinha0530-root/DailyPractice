package com.dsal.leetcode.blind75.linkedlist.questions;

public class ReverseLinkedListInPlace {

    private static ListNode reverseLinkedListInPlace(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode current = head;
        ListNode prev = null;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {

        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode printMain = head;
        while(printMain != null) {
            System.out.print(printMain.value + " -> ");
            printMain = printMain.next;
        }
        System.out.print("END");

        ListNode reversed = reverseLinkedListInPlace(head);
        System.out.println();

        System.out.println("Reversed Nodes are = ");
        while(reversed != null) {
            System.out.print(reversed.value + " -> ");
            reversed = reversed.next;
        }
        System.out.print("END");
    }


    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
