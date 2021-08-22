package com.bridgelabz;

/**
 * Purpose : To create methods for implementing test cases
 * @param <K> This is the first parameter to store the key
 * @param <V>  This is the first parameter to store the value
 */
public class MyHashMap<K, V> {
    MyLinkedList<K> myLinkedList;

    public MyHashMap() {
        this.myLinkedList = new MyLinkedList<>();
    }

    /**
     * This method is created to get the key from linked list
     * @param key This is the first parameter to this method to store the key
     * @return returns the value of that key if it is not null
     */
    public V get(K key) {
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    /**
     * This method is created to add the key and value to hash table from linked list
     * @param key This is the first parameter to this method for storing the key
     * @param value This is the first parameter to this method for storing the value
     */
    public void add(K key, V value) {
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            this.myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }

    @Override
    public String toString() {
        return "MyHashMapNodes{" + myLinkedList + '}';
    }
}
