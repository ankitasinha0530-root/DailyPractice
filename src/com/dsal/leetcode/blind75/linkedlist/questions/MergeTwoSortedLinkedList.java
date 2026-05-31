package com.dsal.leetcode.blind75.linkedlist.questions;

public class MergeTwoSortedLinkedList {

    private static ListNode mergeTwoSortedLinkedList(ListNode listA, ListNode listB) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (listA != null && listB != null){

            if (listA.value < listB.value) {
                current.next = listA;
                listA = listA.next;
            }else {
                current.next = listB;
                listB = listB.next;
            }
            current = current.next;
        }

        current.next = listA == null ? listB : listA;

        return dummy.next;
    }

    public static void main(String[] args) {

        //Floyd's Loop detection algorithm is used with fast and slow pointers

        ListNode head ;
        head = new ListNode(1);
        head.next = new ListNode(8);
        head.next.next = new ListNode(12);
        head.next.next.next = new ListNode(15);
        head.next.next.next.next =  new ListNode(25);
        head.next.next.next.next.next = new ListNode(36);

        ListNode head2 ;
        head2 = new ListNode(6);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(11);
        head2.next.next.next = new ListNode(14);
        head2.next.next.next.next =  new ListNode(15);
        head2.next.next.next.next.next = new ListNode(20);
        head2.next.next.next.next.next.next = new ListNode(25);

        displayNode(mergeTwoSortedLinkedList(head, head2));

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
