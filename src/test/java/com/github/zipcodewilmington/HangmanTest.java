package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
    @Test
    public void testGenerateWord() {
        // Given
        ArrayList<String> wordList = Hangman.getWordList();
        boolean expected = true;

        // When
        String word = Hangman.setCurrentWord(wordList);
        System.out.println(word);

        // Then
        boolean actual = wordList.contains(Hangman.setCurrentWord(wordList));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testOccupyDisplay() {
        // Given
        ArrayList<String> wordList = Hangman.getWordList();
        boolean expected = true;

        // When
//        String word = Hangman.occupyDisplay();
//        System.out.println(word);

        // Then
        boolean actual = wordList.contains(Hangman.setCurrentWord(wordList));
        Assert.assertEquals(expected, actual);
    }
}
