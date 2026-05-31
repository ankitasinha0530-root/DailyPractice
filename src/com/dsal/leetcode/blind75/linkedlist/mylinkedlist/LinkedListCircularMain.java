package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

public class LinkedListCircularMain {

    public static void main(String[] args){

        LinkedListCircular circularLL = new LinkedListCircular();
        circularLL.insertFirst(3);
        circularLL.insertFirst(5);
        circularLL.insertFirst(6);
        circularLL.insertFirst(7);
        circularLL.insertFirst(8);
        circularLL.insertFirst(9);
        circularLL.insertFirst(2);
        circularLL.insertFirst(4);

        System.out.println(circularLL.getSize());
        circularLL.display();

        System.out.println();

        System.out.println();
        System.out.println("Element Removed from first: " + circularLL.removeFirst());
        circularLL.display();

        System.out.println();
        System.out.println("Element Removed from last : " + circularLL.removeLast());
        circularLL.display();

        System.out.println();

        LinkedListCircular circularLL1 = new LinkedListCircular();
        circularLL1.insertLast(3);
        circularLL1.insertLast(5);
        circularLL1.insertLast(6);
        circularLL1.insertLast(7);
        circularLL1.insertLast(8);
        circularLL1.insertLast(10);
        circularLL1.insertLast(11);
        circularLL1.insertLast(4);

        System.out.println();
        System.out.println(circularLL1.getSize());
        circularLL1.display();

        System.out.println();
        System.out.println("Element Removed from Last : " + circularLL1.removeLast());
        circularLL1.display();

        System.out.println();
        System.out.println("Element Removed Last : " + circularLL1.removeLast());
        circularLL1.display();

        System.out.println();
        System.out.println("Element Removed First : " + circularLL1.removeFirst());
        circularLL1.display();


    }
}
