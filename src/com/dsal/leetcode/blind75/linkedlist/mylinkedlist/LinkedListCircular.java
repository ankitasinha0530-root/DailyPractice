package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

import java.util.NoSuchElementException;

public class LinkedListCircular {

    Node head;
    Node tail;
    int size;

    public void insertFirst(int val){

        Node node = new Node(val);
        node.next = head;
        head = node;
        if(size == 0){
            tail = head;
        }else{
            tail.next = head;
        }
        size++;
    }

    public void insertLast(int val){

        if(size == 0){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);

        node.next = head;
        tail.next = node;
        tail = node;
        size++;

    }


    public int removeFirst(){

        if(head == null){
            throw new NoSuchElementException("List is empty");
        }

        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }else {
            tail.next = head;
        }
        size--;
        return val;
    }

    public int removeLast(){

        if(head == null){
            throw new NoSuchElementException("List is empty");
        }

        if(size == 1){
            return removeFirst();
        }

        Node previousToTail = get(size-2);
        System.out.println("Previous value  = " + previousToTail.value);
        int val = previousToTail.next.value;
        previousToTail.next = head;
        tail = previousToTail;
        size--;
        return val;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void display(){
        Node node = head;
        do{
            System.out.print(node.value + " -> ");
            node = node.next;
        } while(node != head);
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
