package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

import java.util.NoSuchElementException;

public class LinkedListDoubly {

//    int value;
    NodeD head;
    NodeD tail;
    int size = 0;

    public void insertFirst(int value){ // it will add to the head

        NodeD node = new NodeD(value);
        node.next = head;

        if (size == 0){
            tail = node;
        }else {
            head.prev = node;
        }
        head = node;
        size++;

    }

    public void insertLast(int value){ // it will add to the head

        if(size == 0){
            insertFirst(value);
            return;
        }

        NodeD node = new NodeD(value);

        tail.next = node;
        node.prev = tail;
        tail = node;

        size++;
    }

    public void insert(int val, int index){

        if(index == 0){
            insertFirst(val);
            return;
        }

        if(index == size - 1){
            insertLast(val);
            return;
        }

        NodeD node = new NodeD(val);
        NodeD prev = get(index - 1);

        node.next = prev.next;
        prev.next.prev = node;
        prev.next = node;
        node.prev = prev;
        size++;
    }

    public NodeD get(int index){
        NodeD node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int removeFirst(){

        if(head == null){
            throw new NoSuchElementException("List is empty");
        }

        int val = head.value;
        head = head.next;

        if(head == null){
            tail = null;
        }else{
            head.prev = null;
        }
        size--;
        return val;
    }

    public int removeLast() {

        if(size == 1){
            return removeFirst();
        }
        int val = tail.value;
        tail = tail.prev;

        if(tail == null){
            head = null;
        }else {
            tail.next = null;
        }
        return val;
    }

    public int remove(int value){

        if(head == null){
            throw new NoSuchElementException("List is empty");
        }

        if(head.value == value){
            return removeFirst();
        }

        if(tail.value == value){
            return removeLast();
        }

        NodeD node = find(value);

        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;

        return value;
    }

    public NodeD find(int value){

        NodeD node = head;

        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int removeAt(int index){

        if(index == 0){
            removeFirst();
        }
        if(index == size - 1){
            removeLast();
        }

        NodeD node = get(index);
        int val = node.value;

        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;

        return val;
    }

//    public int removeLast() {
//
//
//    }
//

//


    public void display(){
        NodeD node = head;
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("END");
    }

    public int getSize(){
        return size;
    }


}



