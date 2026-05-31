package com.dsal.leetcode.blind75.linkedlist.questions;

public class RemoveNthEleFromEndOfList {

    private static ListNode removeNthElementFromLast(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast node to n+1 times;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
            if(fast == null){
                return null;
            }
        }

        // increment fast and slow by 1 when fast is at null then slow will be at previous element to nth (which we want to remove)
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

//        Remove target node as slow is just before the target node
        slow.next = slow.next.next;
        return dummy.next;
        
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


        System.out.println("LinkedList removed element == " +  (removeNthElementFromLast(head, 3)));
        displayNode(head);
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
