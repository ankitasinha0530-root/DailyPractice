package com.dsal.leetcode.blind75.linkedlist.questions;

public class BubbleSortLinkedList {

    private static ListNode bubbleSortLinkedList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        boolean swapped;

        do {
            swapped = false;
            ListNode prev = null;
            ListNode current = head;

            while (current != null && current.next != null){

                if(current.value < current.next.value){

                    ListNode next = current.next;
                    current.next = next.next;
                    next.next = current;

                    if(prev == null){
                        head = next;
                    }else{
                        prev.next = next;
                    }
                    prev = next;
                    swapped = true;

                }else {
                    prev = current;
                    current = current.next;
                }
            }
        } while (swapped);

        return head;
    }

    public static void main(String[] args) {
        //Floyd's Loop detection algorithm is used with fast and slow pointers
        ListNode head ;
        head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(9);
        head.next.next.next.next.next = new ListNode(7);


        displayNode(bubbleSortLinkedList(head));

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
