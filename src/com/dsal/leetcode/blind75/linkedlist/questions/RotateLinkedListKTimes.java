package com.dsal.leetcode.blind75.linkedlist.questions;

public class RotateLinkedListKTimes {

    private static ListNode rotateLinkedListKTimes(ListNode head, int k) {

        ListNode node = head;
        int size = 1;

        while (node.next != null){
            node = node.next;
            size++;
        }

        node.next = head;// make it circular;
        int rotationNum = size - k % size;

        node = head;        // start looping from head to move to new Head by skipping rotationNum elements
        for (int i = 1; i < rotationNum; i++) {
            node = node.next;
        }

        ListNode newHead = node.next;
        node.next = null; // break the circlular

        return newHead;
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


        displayNode(rotateLinkedListKTimes(head, 3));
        
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
