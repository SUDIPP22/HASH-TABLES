package com.bridgelabz;

import java.util.ArrayList;

/**
 * Purpose : To create methods for implementing test cases for MyLinkedHashMapTest class
 * @param <K> This parameter is used to store the key
 * @param <V> This parameter is used to store the value
 */
public class MyLinkedHashMap<K, V> {
    private final int numOfBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;

    public MyLinkedHashMap() {
        this.numOfBuckets = 10;
        this.myBucketArray = new ArrayList<>(numOfBuckets);
        // Creating an empty LinkedList
        for (int i = 0; i < numOfBuckets; i++) {
            this.myBucketArray.add(null);
        }
    }

    /**
     * This method implements hash function to find index for a key
     * @param key This is the parameter for storing key
     * @return returns the index position
     */
    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numOfBuckets;
        System.out.println("Key : " + key + " Hashcode : " + hashCode + " Index : " + index);
        return index;
    }

    /**
     * This method is used for getting the LinkedList and searching the key
     * @param key This is the parameter to store the key
     * @return return the value
     */
    public V get(K key) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) return null;
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    /**
     * This method is created for adding the key and value in HashMap by using LinkedList
     * @param key This is the first parameter to this method for storing the key
     * @param value This is the second parameter to this method for storing the value
     */
    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        MyLinkedList<K> myLinkedList = this.myBucketArray.get(index);
        if (myLinkedList == null) {
            myLinkedList = new MyLinkedList<>();
            this.myBucketArray.set(index, myLinkedList);
        }
        MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) myLinkedList.search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            myLinkedList.append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }
    @Override
    public String toString() { return "MyLinkedHashMap List{" +myBucketArray+ '}'; }
}
