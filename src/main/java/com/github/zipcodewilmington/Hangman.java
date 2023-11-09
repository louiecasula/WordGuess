package com.github.zipcodewilmington;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
// Louie wuz here
public class Hangman {
    private String currentWord;
    private String prompt;
    private int guessesLeft;
    private ArrayList<Character> guesses;
    private ArrayList<Character> wordArr;
    private ArrayList<Character> display;
    public ArrayList<String> wordList;

    public Hangman() {
//        this("","Enter a single character: ", Integer.MAX_VALUE, new ArrayList<Character>(), new ArrayList<Character>(), new ArrayList<Character>());
        this.currentWord = "";
        this.prompt = "Enter a single character: ";
        this.guessesLeft = Integer.MAX_VALUE;
        this.guesses = new ArrayList<Character>();
        this.wordArr = new ArrayList<Character>();
        this.display = new ArrayList<Character>();
        // Importing the wordList
        ArrayList<String> wordList = new ArrayList<>();

        Scanner fileIn;
        try {
            fileIn = new Scanner(new File("/Users/louie/projects/WordGuess/src/main/java/com/github/zipcodewilmington/WordBank.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (fileIn.hasNext()) {
            String lineIn = fileIn.nextLine();
            wordList.add(lineIn);
        }
        this.wordList = wordList;
    }

    public void setCurrentWord(ArrayList<String> wordList) {
        Random random = new Random();
        this.currentWord = wordList.get(random.nextInt(wordList.size()));
    }

    public String getCurrentWord(){
        return currentWord;
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void setPrompt(String newPrompt) {
        this.prompt = newPrompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setWordArr(String currentWord) {
//        this.wordArr = currentWord.toCharArray();
    }
}
