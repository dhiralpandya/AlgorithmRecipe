package com.omtlab.algorithmrecipe.string.map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class LC242Test {
    @Test
    void testIsAnagram_True() {
        LC242 lc242 = new LC242();
        assertTrue(lc242.isAnagram("anagram", "nagaram"));
    }

    @Test
    void testIsAnagram_False() {
        LC242 lc242 = new LC242();
        assertFalse(lc242.isAnagram("cat", "rat"));
    }
}
