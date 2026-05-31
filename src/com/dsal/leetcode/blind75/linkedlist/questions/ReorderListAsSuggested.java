package com.dsal.leetcode.blind75.linkedlist.questions;

import com.dsal.leetcode.blind75.linkedlist.mylinkedlist.Node;

public class ReorderListAsSuggested {

/**  Example
    Input: head = [1,2,3,4]
    Output: [1,4,2,3]

    Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
 */

private static ListNode reorderLinkedList(ListNode head) {

    // Find Middle
    ListNode slow = head;
    ListNode fast = head;
    ListNode previous = null;

    while (fast != null && fast.next != null) {
        previous = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    previous.next = null;

//    Reverse from middle to last

    ListNode curr = slow;
    ListNode prev = null;

    while (curr != null) {

        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    // start reordering
    ListNode currNode = head;
    ListNode secondCurrent = prev;

    ListNode prevEleToSecondCurrent = null;
    while (currNode != null && secondCurrent != null) {

        ListNode next = currNode.next;
        ListNode secondNext = secondCurrent.next;

        currNode.next = secondCurrent;
        secondCurrent.next = next;

        currNode = next;
        prevEleToSecondCurrent = secondCurrent;
        secondCurrent = secondNext;
    }
    if (secondCurrent != null) {
        prevEleToSecondCurrent.next = secondCurrent;
    }

    return head;

}

    public static void reorderList(ListNode head) {

        if (head==null || head.next == null ) return ;

        // Find Middle
        ListNode slow = head;
        ListNode fast = head ;

        while (fast != null && fast.next != null){
            slow = slow.next ;
            fast= fast.next.next;

        }
        ListNode prev = null ;
        ListNode curr = slow.next ;
        slow.next = null;

        // Reverse from slow.next
        while(curr != null){

            ListNode nextTemp = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = nextTemp;

        }
        ListNode first = head ;
        ListNode second = prev;

        // Reorder
        while (second != null ){
            ListNode next = first.next;
            ListNode secNext = second.next;

            first.next = second;
            second.next= next;

            first = next;
            second = secNext;

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

//        ListNode resultHead = reorderLinkedList(head);
//        displayNode(resultHead);

//        ListNode resultHead2 = reorderLinkedList(head2);
//        displayNode(resultHead2);

        reorderList(head);
        displayNode(head);

        reorderList(head2);
        displayNode(head2);

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
