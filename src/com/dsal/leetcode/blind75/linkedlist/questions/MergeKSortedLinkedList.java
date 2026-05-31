package com.dsal.leetcode.blind75.linkedlist.questions;

import java.util.Arrays;
import java.util.List;

public class MergeKSortedLinkedList {

    private static ListNode mergeKSortedLinkedList(ListNode[] lists, int start, int end){

        if(start == end){
            return lists[start];
        }

        if(start + 1 == end){
            return mergeTwoSortedLinkedList(lists[start], lists[end]);
        }

        int mid = start + (end - start)/2;

        ListNode left = mergeKSortedLinkedList(lists, start, mid);
        ListNode right = mergeKSortedLinkedList(lists, mid + 1, end);

        return mergeTwoSortedLinkedList(left, right);
    }


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

        ListNode head3 ;
        head3 = new ListNode(4);
        head3.next = new ListNode(6);
        head3.next.next = new ListNode(18);
        head3.next.next.next = new ListNode(21);
        head3.next.next.next.next =  new ListNode(35);
        head3.next.next.next.next.next = new ListNode(46);

        ListNode head4;
        head4 = new ListNode(1);
        head4.next = new ListNode(13);
        head4.next.next = new ListNode(11);
        head4.next.next.next = new ListNode(17);
        head4.next.next.next.next =  new ListNode(22);
        head4.next.next.next.next.next = new ListNode(26);

        displayNode(mergeKSortedLinkedList(new ListNode[]{head, head2, head3, head4}, 0, 3));

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
