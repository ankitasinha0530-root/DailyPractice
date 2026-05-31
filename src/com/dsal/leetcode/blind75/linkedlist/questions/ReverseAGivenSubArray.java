package com.dsal.leetcode.blind75.linkedlist.questions;

import java.util.List;

public class ReverseAGivenSubArray {

    // https://www.youtube.com/watch?v=oDL8vuu2Q0E&t=135s

    private static ListNode reverseAGivenSubArray(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevToLeft = dummy;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) {  // move and bring prev To leaft and currNode to that position
            prevToLeft = prevToLeft.next;
            currNode = currNode.next;

        }

        ListNode subListHead = currNode;
        ListNode prev = null;

        for (int i = 0; currNode != null && i < right - left + 1; i++) {

            ListNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        prevToLeft.next = prev;
        subListHead.next = currNode;

        return dummy.next;
    }


    private static ListNode getNode(ListNode head, int left) {

        ListNode node = head;
        for (int i = 0; i < left; i++) {
            node = node.next;
        }
        return node;
    }


    public static void main(String[] args) {

        //Floyd's Loop detection algorithm is used with fast and slow pointers

        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode headNode = reverseAGivenSubArray(head, 2, 5);

        while (headNode != null) {
            System.out.println(headNode.value + " -> ");
            headNode = headNode.next;
        }


    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

}

