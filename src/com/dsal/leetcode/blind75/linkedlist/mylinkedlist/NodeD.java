package com.dsal.leetcode.blind75.linkedlist.mylinkedlist;

public class NodeD {

    int value;
    NodeD next;
    NodeD prev;

    public NodeD(int value) {
        this.value = value;
    }

    public NodeD(int value, NodeD next, NodeD prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public NodeD(int value, NodeD next) {
        this.value = value;
        this.next = next;
    }

//    public NodeD(int value, NodeD prev) {
//        this.value = value;
//        this.prev = prev;
//    }
}
