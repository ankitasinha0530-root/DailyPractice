package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

public class LinkedListDoublyMain {

    public static void main(String[] args){

        LinkedListDoubly doublyLL = new LinkedListDoubly();
        doublyLL.insertFirst(3);
        doublyLL.insertFirst(5);
        doublyLL.insertFirst(6);
        doublyLL.insertFirst(7);
        doublyLL.insertFirst(8);
        doublyLL.insertFirst(9);
        doublyLL.insertFirst(2);
        doublyLL.insertFirst(4);

        System.out.println(doublyLL.getSize());
        doublyLL.display();

        System.out.println();

        System.out.println("Insert by value and index");
        doublyLL.insert(20, 6);
        doublyLL.display();

        System.out.println();
        doublyLL.insert(100, 4);
        doublyLL.display();

        System.out.println();
        System.out.println("Element Removed from first: " + doublyLL.removeFirst());
        doublyLL.display();

        System.out.println();
        System.out.println("Element Removed from last : " + doublyLL.removeLast());
        doublyLL.display();


        System.out.println();
        System.out.println("Element Removed : " + doublyLL.remove(6));
        doublyLL.display();

        System.out.println();
        System.out.println("Element Removed at index: " + doublyLL.removeAt(4));
        doublyLL.display();

        System.out.println();
        System.out.println("Element at index 4 is : " + doublyLL.get(4));




        LinkedListDoubly doublyLL1 = new LinkedListDoubly();
        doublyLL1.insertLast(3);
        doublyLL1.insertLast(5);
        doublyLL1.insertLast(6);
        doublyLL1.insertLast(7);
        doublyLL1.insertLast(8);
        doublyLL1.insertLast(10);
        doublyLL1.insertLast(11);
        doublyLL1.insertLast(4);

        System.out.println();
        System.out.println(doublyLL1.getSize());
        doublyLL1.display();

        System.out.println();
        System.out.println("Element Removed : " + doublyLL1.removeLast());
        doublyLL1.display();

        System.out.println();
        System.out.println("Element Removed : " + doublyLL1.removeLast());
        doublyLL1.display();

        System.out.println();
        System.out.println("Element at index 3 is : " + doublyLL1.get(3));


    }
}
