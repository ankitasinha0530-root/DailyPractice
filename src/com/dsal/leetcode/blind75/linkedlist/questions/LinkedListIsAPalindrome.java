package com.dsal.leetcode.blind75.linkedlist.questions;

public class LinkedListIsAPalindrome {

    // https://www.youtube.com/watch?v=WyI5dXMHW5c - fro understanding

    private static boolean liskedListIsApalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        ListNode first = head;
        ListNode second = prev;

        while(first != null && second != null){
            if(first.value != second.value){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

    private static boolean liskedListIsApalindromeV2(ListNode head) {

        // if start and end point is not given then find mid using 2 pointers.

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null) { // as we want to keep right side smaller in case of odd no. of elements
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while(slow != null && fast != null){
            if(slow.value != fast.value){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }



    private static ListNode reverseList(ListNode head){

        // if(head == null || head.next == null){
        //     return head;
        // }

        ListNode currNode = head;
        ListNode prev = null;

        while (currNode != null){
            ListNode next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;

        }
        return prev;
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

        System.out.println("LinkedList is a Palindrome == " + liskedListIsApalindrome(head));

    }

    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }

}
