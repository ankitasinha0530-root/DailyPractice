package com.dsal.leetcode.blind75.linkedlist.questions;

public class ReverseKThenSkipKRepeat {

    private static ListNode reverseInKGroupsThenSkipKandRepeat(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevEleToTheCurrentGroup = dummy;

        while (true) {

            ListNode kthListNode = prevEleToTheCurrentGroup;

            for (int i = 0; i < k; i++) {
                kthListNode = kthListNode.next;
                if(kthListNode == null){
                    return dummy.next;
                }
            }

            ListNode currentGroupStart = prevEleToTheCurrentGroup.next;
            ListNode nextGroupStart = kthListNode.next;

            // Reverse

            ListNode current = currentGroupStart;
            ListNode previous = nextGroupStart;


            while (current != nextGroupStart){

                ListNode next = current.next;
                current.next = previous;

                previous = current;
                current = next;
            }

            prevEleToTheCurrentGroup.next = kthListNode;

            // Skipping K element
            ListNode startSkippingEle = currentGroupStart;

            for (int j = 0; j < k; j++) {

                startSkippingEle = startSkippingEle.next;
                if(startSkippingEle == null){
                    return dummy.next;
                }
            }
            prevEleToTheCurrentGroup = startSkippingEle;
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
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);



        ListNode head2 ;
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next =  new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = new ListNode(7);
        head2.next.next.next.next.next.next.next = new ListNode(8);

        ListNode resultHead = reverseInKGroupsThenSkipKandRepeat(head, 3);
        displayNode(resultHead);

        ListNode listNode = reverseInKGroupsThenSkipKandRepeat(head2, 3);
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
