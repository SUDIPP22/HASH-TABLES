package com.bridgelabz;

/**
 * Purpose : To create LinkedList methods for implementing using HashMap
 * @param <K> This is the parameter of the MyLinkList class
 */
public class MyLinkedList<K> {
    public INode<K> head;
    public INode<K> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /* This method is used to add the elements to the linked list */
    public void add(INode<K> newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode<K> tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    /* This method is used to append the elements to the linked list */
    public void append(INode<K> myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    /* This method is used to insert the element in between two nodes */
    public void insert(INode<K> myNode, INode<K> newNode) {
        INode<K> tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    /* This method is used for deleting the first node */
    public INode<K> pop() {
        INode<K> tempNode = this.head;
        this.head = head.getNext();
        return tempNode;
    }

    /* This method is used for deleting the last node */
    public INode<K> popLast() {
        INode<K> tempNode = head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode.setNext(null);
        return tempNode;
    }

    /* This method is used for searching position of a node element in the list */
    public INode<K> search(K key) {
        INode<K> tempNode = head;
        int position = 0;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            }
            tempNode = tempNode.getNext();
        }
        return null;
    }

    /* This method is used for displaying the output */
    public void printMyNodes() {
        System.out.println("My Nodes : " + head);
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" +
                "head->" + head +
                '}';
    }
}
