package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Purpose : To create the Test class which is used for checking the test cases.
 */
public class MyLinkedHashMapTest {

    /**
     * This is the first test case which is used to find frequency of paranoid
     * in a sentence - "Paranoids are not paranoid because they are paranoid but " +
     *                 "because they keep putting themselves deliberately into " +
     *                 "paranoid avoidable situations";
     */
    @Test
    public void givenASentenceWhenWordsAreAddedToListShouldReturnParanoidFrequency() {
        String sentence = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately into " +
                "paranoid avoidable situations";
        MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        /* Iterates over the array of the sentence */
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null) value = 1;
            else value = value + 1;
            myLinkedHashMap.add(word, value);
        }
        int frequency = myLinkedHashMap.get("paranoid");
        System.out.println(myLinkedHashMap);
        Assertions.assertEquals(3, frequency);
    }
}