package com.dsal.leetcode.blind75.linkedlist.questions;

public class ReverseEveryKItemsInLinkedList {

    // https://www.youtube.com/watch?v=-2cbMLCUCiI
    // https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/2017615968/

    private static ListNode reverseinKGroups(ListNode head, int k) {
        // Create a dummy ListNode
        ListNode dummy = new ListNode(0);
        dummy.next = head;  // Assign head so now list would be dummy -> 1-> 2-> 3-> 4-> 5 -> 6....

        ListNode prevElementToTheGroup = dummy;  // Assign for the 1st time

        while (true) {
            // Find Kth element
            ListNode kthListNode = prevElementToTheGroup;
            for (int i = 0; i < k; i++) { // i = 0 as we are starting from prevElementToTheGroup
                kthListNode = kthListNode.next;
                if(kthListNode == null){
                    return dummy.next; // since there no more group of k element exists
                }
            }

            ListNode currentGroupStart = prevElementToTheGroup.next;
            ListNode nextGroupStart = kthListNode.next;

            // Reverse the elements of the current group
            ListNode prev = nextGroupStart;
            ListNode current = currentGroupStart;

            while (current != nextGroupStart){
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            // Connect
            prevElementToTheGroup.next = kthListNode; // After reversing kthListNode will become the first element

            prevElementToTheGroup = currentGroupStart; // current group start should br the previous element to the next group after reversal
        }

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

        ListNode head2 ;
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next =  new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);

        ListNode resultHead = reverseinKGroups(head, 3);
        displayNode(resultHead);

        ListNode listNode = reverseinKGroups(head2, 3);
        displayNode(listNode);

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value) {
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
