package org.example.anagram.test;
import static org.junit.Assert.assertEquals;

import org.example.anagram.Anagram;
import org.junit.Test;

public class AnagramTest {
    Anagram anagram = new Anagram();

    @Test
    public void shouldReturnEmptyString_whenInsertEmptyString() {
        assertEquals("", anagram.makeAnagram(""));
    }

    @Test
    public void shouldReturnOneSymbol_whenInsertOneSymbol() {
        assertEquals("x", anagram.makeAnagram("x"));
    }

    @Test
    public void shouldReturnReversed_whenInsertWord() {
        assertEquals("yx", anagram.makeAnagram("xy"));
    }

    @Test
    public void shouldReturnReversedWithSpace_whenInsertWordsWithSpace() {
        assertEquals("yx vz", anagram.makeAnagram("xy zv"));
    }
    
    @Test
    public void shouldReturnReversedWithSpace2_whenInsertWordsWithSpace2() {
        assertEquals("yx z", anagram.makeAnagram("xy z"));
    }    
}
