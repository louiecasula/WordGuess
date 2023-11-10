package com.github.zipcodewilmington;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
// Louie wuz here
public class Hangman {
    public static void main(String [] args) {
        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = importWords();
        String currentWord = generateWord(wordList).toLowerCase();
        int guessesLeft = currentWord.length();
        ArrayList<String> wordArr = new ArrayList<>(Arrays.asList(currentWord.split("")));
        iterate(wordArr);
        ArrayList<String> guesses = new ArrayList<>();

        // Start game
        System.out.println("Let's Play Wordguess version 1.0");
        while (guessesLeft > 0) {
            // Include a boolean that determines if whole word has been guessed.
            System.out.println("Current Guesses: ");
            iterate(displayStatus(guesses, wordArr));
            System.out.printf("You have %d tries left.\n", guessesLeft);
            String guess;
            while (true) {
                guess = promptUser("Enter a single character: ");
                if (isValidGuess(guesses, guess)) {
                    guesses.add(guess);
                    guessesLeft--;
                    break;
                }
            }
        }
    }


    public static String promptUser(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static boolean isValidGuess(ArrayList<String> guesses, String guess) {
        return !wasAlreadyGuessed(guesses, guess) && !notSingleLetter(guess);
    }

    private static boolean wasAlreadyGuessed(ArrayList<String> guesses, String guess) {
        if (guesses.contains(guess)) {
            System.out.println("You already guessed that!");
            return true;
        }
        return false;
    }

    private static boolean notSingleLetter(String guess) {
        if (guess.length() != 1) {
            System.out.println("Guess must be just one letter!");
            return true;
        }
        return false;
    }

    private static void quitGame(String guess) {
        if (guess.equals("-")) {
            System.exit(0);
        }
    }

    public static ArrayList<String> displayStatus (ArrayList<String> guesses, ArrayList<String> wordArr){
        ArrayList<String> display = new ArrayList<>();
        // For initial turn
        if (guesses.isEmpty()) {
            for (String letter: wordArr) {
                display.add("_");
            }
            return display;
        }
        // After the first guess
        for (int i = 0; i < wordArr.size(); i++) {
            for (String guess : guesses) {
                if (wordArr.get(i).equals(guess)) {
                    display.add(i, guess);
                } else {
                    display.add(i,"_");
                }
            }
        }
        return display;
    }

    public static void iterate (ArrayList<String> array){
        for (String s : array) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String generateWord (ArrayList < String > wordList) {
        Random random = new Random();
        String currentWord = wordList.get(random.nextInt(wordList.size()));
        return currentWord;
    }

    public static ArrayList<String> importWords() {
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
        return wordList;
    }
}
