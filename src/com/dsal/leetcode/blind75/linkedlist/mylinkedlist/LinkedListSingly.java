package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;


import java.util.NoSuchElementException;

public class LinkedListSingly {

    int val;
    Node head;
    Node tail;
    int size = 0;

    public Node add(int value){ // it will add to the head

        Node node = new Node(value);
        node.next = head;
        head = node;

        return head;
    }

    public void insertFirst(int value){ // it will add to the head

        Node node = add(value);
        if(size == 0){
            tail = node;
        }
        size++;
    }

    public void insertLast(int value){ // it will add to the head

       if(size == 0){
           insertFirst(value);
           return;
       }
       Node node = new Node(value);
       tail.next = node;
       tail = node;
       size++;

    }

    public void insert(int val, int index){

        if (index == 0){
            insertFirst(val);
        }
        if (index == size){
            insertLast(val);
        }

        Node newNode = new Node(val);
        Node node = get(index-1);

        newNode.next = node.next;
        node.next = newNode;
        size++;

    }

    public Node get(int index){

        Node node = head;
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
        if(head == null) {
            tail = null;
        }
        size--;

        return val;
    }

    public int deleteLast() {

        if(size <= 1){
            return removeFirst();
        }
        Node secondLast = get(size - 2); // size-1 would have the last element, we want 2nd second last element, hence,

        int val = tail.value;
        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public int removeLast() {

        if(head == null){
            throw new NoSuchElementException("List is empty");
        }

        if(head == tail){
            int val = head.value;
            head = null;
            tail = null;
            size--;
            return val;
        }
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = null;
        tail = temp;
        size--;
        return  val;
    }

    public int remove(int value){

        if(head.value == value){
            removeFirst();
        }

        if(tail.value == value){
            removeLast();
        }

        Node node = find(value);
        node.next = node.next.next;
        size--;

        return value;
    }

    public Node find(int value){

        Node node = head;

        while(node.next != null){
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

        if(index == size-1){
            removeLast();
        }

        Node prev = get(index-1);
        int val = prev.next.value;
        prev.next = prev.next.next;

        return val;

    }

    public int getSize(){
        return size;
    }



    public Node reverseLinkedListInPlace(){// 9->8->7->6->20->5->3->END

        if(head == null || head == tail){
            return null;
        }
        Node current = head;
        Node prev = null;

        while(current != null){

            Node next = current.next; // keep next element

            current.next = prev; // assign current.nect to prev
            prev = current; // prev = current
            current = next; // current = next

        }

        return prev;
    }

    public Node reverseLinkedListRecursion(){

        return reverseUsingRecursion(head);

    }

    private Node reverseUsingRecursion(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseUsingRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }


    public void display(){
        Node node = head;
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("END");
    }

    public void displayNode(Node node){
//        Node node = head;
        while(node != null){
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("END");
    }

}
