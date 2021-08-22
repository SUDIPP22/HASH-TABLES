package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is the Test class which is used for checking the test cases.
 */
public class MyHashMapTest {

    /**
     * This is the first test case which is used to find frequency
     * of words in a sentence - "To be or not to be"
     */
    @Test
    public void givenASentenceWhenWordsAreAddedToListShouldReturnWordFrequency() {
        String sentence = "To be or not to be";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");

        /* Iterates over the array of the sentence */
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myHashMap.add(word, value);
        }
        int frequency = myHashMap.get("to");
        System.out.println(myHashMap);
        Assertions.assertEquals(2, frequency);
    }

}