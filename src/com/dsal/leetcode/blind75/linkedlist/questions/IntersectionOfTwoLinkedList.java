package com.dsal.leetcode.blind75.linkedlist.questions;

public class IntersectionOfTwoLinkedList {

    private static ListNode findInterSectionOfLinkedList(ListNode headA, ListNode headB) {

        if (headA == null || headB == null){
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = (nodeA == null) ? headB : nodeA.next;
            nodeB = (nodeB == null) ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {


        ListNode head ;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode head2 ;
        head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next =  head.next.next.next;
        head2.next.next.next.next.next = head.next.next.next.next;
        head2.next.next.next.next.next.next = head.next.next.next.next.next;

        ListNode intersectionPoint = findInterSectionOfLinkedList(head, head2);

        System.out.println(intersectionPoint == null ? null : intersectionPoint.value);

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
