package com.omtlab.algorithmrecipe.set;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class SubSetExampleTest {

    SubSetExample subSetExample = new SubSetExample();

    @Test
    public void returnIntegersBetween() {
        List<Integer> input = Lists.newArrayList(2, 5, 4, 3, 7, 6, 8, 10, 9);
        // Now we need all integers between 2 (Inclusive) to 8 (Exclusive)
        System.out.println(subSetExample.returnIntegersBetween(input, 2, 8));

        // Now return integers between 2 (Inclusive) to 1000 (Exclusive)
        // This is not going to throw any exception.
        System.out.println(subSetExample.returnIntegersBetween(input, 2, 1000));
    }

    @Test
    public void returnWordsBetween() {
        List<String> words = Lists.newArrayList("Aaa", "Cccc",
                "Www", "Zzzz", "Yyyy", "Pppp", "Eee", "Ddddd", "Hhhh");

        // Return words from A to G
        // Here we dont need to specify exact name/word, Just first letter is enough.
        System.out.println(subSetExample.returnWordsBetween(words, "A", "G"));
    }

    @Test
    public void returnWordsStartsWithTailSet() {
        List<String> words = Lists.newArrayList("apple", "car",
                "appapp", "appnew", "some", "Pppp", "Eee", "Ddddd", "Hhhh", "appfkjldmfdlkf");

        // Return words from A to G
        // Here we dont need to specify exact name/word, Just first letter is enough.
        System.out.println(subSetExample.returnWordsStartsWithTailSet(words, "app"));
    }
}