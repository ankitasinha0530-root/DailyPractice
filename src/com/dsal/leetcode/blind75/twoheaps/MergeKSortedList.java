package com.dsal.leetcode.blind75.twoheaps;

import java.util.List;
import java.util.PriorityQueue;

// LinkedList
public class MergeKSortedList {

    public static void main(String[] args) {

        // List1: 1 -> 4 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // List2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // List3: 2 -> 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode result = mergeKLists(lists);
        printList(result);

    }

    private static ListNode mergeKLists(ListNode[] listNodes) {

        // Priority queue
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

//        This list of ListNodes will have only the root element as 1st element,
//            so put those root element to mean heap
        for (ListNode listNode : listNodes){
            if(listNode != null) {
                minHeap.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(-1); // Create a dummy ListNote
        ListNode current = dummy;                   // assign current element as dummy with val = -1 and next as null

        while(!minHeap.isEmpty()){   // untill minHeap becomes empty keep extracting smallest element from TOP
            ListNode smallest = minHeap.poll(); //

            current.next = smallest; // now current.next is assign with smallest
            current = current.next; // move to next element which is smallest.next or current.next

            // insert next node from the same list
            if(smallest.next != null){ // we want original list to put in  minHEap
                minHeap.offer(smallest.next);
            }
        }
        return dummy.next; // as the actual elements start from dummy.next
    }

    public static void printList(ListNode root){

        while (root.next != null){
            System.out.print(root.value + ", ");
        }
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
