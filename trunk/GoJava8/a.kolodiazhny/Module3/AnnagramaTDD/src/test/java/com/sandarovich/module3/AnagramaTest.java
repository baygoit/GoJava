package com.sandarovich.module3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple Annagramma TDD
 */

public class AnagramaTest {
    private Anagrama annagrama;

    @Before
    public void initialize() {
        annagrama = new Anagrama();
        annagrama.setDeltimer(" ");
    }

    @Test
    public void testBlankLine() {
        //given
        String inputText = "";
        String expectedText = "";
        //then
        assertEquals("Test for blank line", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testOneChar() {
        //given
        String inputText = "Z";
        String expectedText = "Z";
        //then
        assertEquals("Test for one char only", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testOneWord() {
        //given
        String inputText = "Successfully";
        String expectedText = "yllufsseccuS";
        //then
        assertEquals("Test for one word only", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testTwoWordSepearatedDeltimer() {
        //given
        String inputText = "Successfully day";
        String expectedText = "yllufsseccuS yad";
        //then
        assertEquals("Test for two words which is separated by deltimer", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testThreeWordSepearatedDeltimer() {
        //given
        String inputText = "Successfully day yeah!";
        String expectedText = "yllufsseccuS yad !haey";
        //then
        assertEquals("Test for two words which is separated by deltimer", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testOneLetterAndWords() {
        //given
        String inputText = "A brave new world!!!";
        String expectedText = "A evarb wen !!!dlrow";
        //then
        assertEquals("Test for two words which is separated by deltimer", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testDifferentDelimeter() {
        //given
        annagrama.setDeltimer("#");
        String inputText = "A#brave#new#world!!!";
        String expectedText = "A#evarb#wen#!!!dlrow";
        //then
        assertEquals("Test for sentence which is separated by other" +
                " deltimer", expectedText, annagrama.get(inputText));
    }

    @Test
    public void testMoreThanOneDeltimer() {
        //given
        String inputText = "A brave   new    world!!!";
        String expectedText = "A evarb   wen    !!!dlrow";
        assertEquals("Test for using more then one deltimer in sentence",
                expectedText, annagrama.get(inputText));

    }



}
