package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

public class LinkedListSinglyMain {

    public static void main(String[] args){

        LinkedListSingly singlyLL = new LinkedListSingly();
        singlyLL.insertFirst(3);
        singlyLL.insertFirst(5);
        singlyLL.insertFirst(6);
        singlyLL.insertFirst(7);
        singlyLL.insertFirst(8);
        singlyLL.insertFirst(9);
        singlyLL.insertFirst(2);
        singlyLL.insertFirst(4);

        System.out.println(singlyLL.getSize());
        singlyLL.display();

        System.out.println();
        System.out.println("Element Removed : " + singlyLL.removeFirst());
        singlyLL.display();

        System.out.println();
        System.out.println("Element Removed : " + singlyLL.removeFirst());
        singlyLL.display();

        System.out.println();
        System.out.println("Element at index 4 is : " + singlyLL.get(4));

        System.out.println("Insert by value and index");
        singlyLL.insert(20, 4);
        singlyLL.display();
        System.out.println();



        System.out.println();
        System.out.println();
        System.out.println("Another starts from here");
        System.out.println();
        LinkedListSingly singlyLL1 = new LinkedListSingly();
        singlyLL1.insertLast(3);
        singlyLL1.insertLast(5);
        singlyLL1.insertLast(6);
        singlyLL1.insertLast(7);
        singlyLL1.insertLast(8);
        singlyLL1.insertLast(10);
        singlyLL1.insertLast(11);
        singlyLL1.insertLast(4);

        System.out.println();
        System.out.println(singlyLL1.getSize());
        singlyLL1.display();

        System.out.println();
        System.out.println("Element Removed : " + singlyLL1.removeLast());
        singlyLL1.display();

        System.out.println();
        System.out.println("Element Removed : " + singlyLL1.removeLast());
        singlyLL1.display();

        System.out.println();
        System.out.println("Element at index 3 is : " + singlyLL1.get(3));


    }
}
