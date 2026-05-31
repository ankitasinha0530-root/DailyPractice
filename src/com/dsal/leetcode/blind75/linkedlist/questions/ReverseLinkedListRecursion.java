package com.dsal.leetcode.blind75.linkedlist.questions;

public class ReverseLinkedListRecursion {

    private static ListNode reverseLinkedListRecursion(ListNode head) {

        //Base Condiiton
        if(head == null || head.next == null){
            return head;
        }

        // Reverse remaining list
        ListNode newNode = reverseLinkedListRecursion(head.next);

        // Reverse current connection
        head.next.next = head;

        // Remove old forward link
        head.next = null;

        return newNode;
    }



    public static void main(String[] args) {

        ListNode head;
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode printMain = head;
        while(printMain != null) {
            System.out.print(printMain.value + " -> ");
            printMain = printMain.next;
        }
        System.out.print("END");

        ListNode reversed = reverseLinkedListRecursion(head);
        System.out.println();

        System.out.println("Reversed Nodes are = ");
        while(reversed != null) {
            System.out.print(reversed.value + " -> ");
            reversed = reversed.next;
        }
        System.out.print("END");
    }


    static class ListNode {           // Always make LisNode class as Static
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}


/**
FINAL UNDERSTANDING

newHead ALWAYS stores:

        👉 Head of the fully reversed linked list

And that head is ALWAYS the last node of original list.

Why Does It Always Stay 4?

Because once base case returns:

        4

every recursive call simply forwards it upward:

        return newHead;

Nobody changes it.

        So:

reverse(4) returns 4
reverse(3) returns 4
reverse(2) returns 4
reverse(1) returns 4
Visual Flow
reverse(4) returns 4
        ↑
reverse(3) gets newHead = 4, returns 4
        ↑
reverse(2) gets newHead = 4, returns 4
        ↑
reverse(1) gets newHead = 4, returns 4
Biggest Intuition

The recursion is doing TWO things:

        1️⃣ Reversing links during backtracking
node.next.next = node;
2️⃣ Carrying the new head upward
return newHead;

Without returning newHead, caller would lose reference to the new head of reversed list.

 That is the core intuition.

 The very last recursive call returns the last node:

 4

 After that, every function call simply does:

 return newHead;

 Nobody modifies:

 newHead

 So the same node reference keeps travelling upward through the recursion stack.

 Think Like This

 At base case:

 return 4;

 Now stack starts unwinding.

 reverse(3)

 Gets:

 newHead = 4

 Does reversal work:

 4 -> 3

 But never changes:

 newHead

 Then returns:

 return newHead; // still 4
 reverse(2)

 Gets:

 newHead = 4

 Again reverses links:

 4 -> 3 -> 2

 But still:

 newHead = 4

 Returns it unchanged.

 Important Distinction

 We ARE changing links in the list:

 node.next.next = node;

 BUT we are NOT changing the variable:

 newHead

 That variable always points to:

 the last node of original list

 which becomes:

 the first node of reversed list
 One More Important Concept

 newHead is not a copy.

 It is a reference.

 So:

 newHead = 4

 means:

 newHead points to node 4

 Even if links around node 4 change:

 4 -> 3 -> 2 -> 1

 the reference still points to node 4.

 That’s why it remains valid throughout recursion unwind.

*/
