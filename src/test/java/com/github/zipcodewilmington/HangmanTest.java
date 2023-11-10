package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
    @Test
    public void testGenerateWord() {
        // Given
        ArrayList<String> wordList = Hangman.importWords();
        boolean expected = true;

        // When
        String word = Hangman.generateWord(wordList);
        System.out.println(word);

        // Then
        boolean actual = wordList.contains(Hangman.generateWord(wordList));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDisplayStatus() {
        // Given
        String currentWord = "banana";
        ArrayList<String> wordArr = new ArrayList<>(Arrays.asList(currentWord.split("")));
        ArrayList<String> guesses = new ArrayList<>();
        guesses.add("a");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("_", "a", "_", "a", "_", "a"));

        // When
        ArrayList<String> display = Hangman.displayStatus(guesses, wordArr);
        System.out.println(display);

        // Then
        Assert.assertEquals(expected, display);
    }
}
