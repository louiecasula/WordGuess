package com.github.zipcodewilmington;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wordList = importWords();
        String currentWord = generateWord(wordList);

        int length = currentWord.length();
        int guessesLeft = length;
        String[] wordArr = currentWord.split("");
        String[] guesses = new String[length];
//        ArrayList<String> guesses = new ArrayList<>();
        String[] display = occupyDisplay(length);
        System.out.println("Let's Play Wordguess version 1.0");
        while (guessesLeft > 0) {
            // Include a boolean that determines if whole word has been guessed.
            System.out.println("Current Guesses: ");
            if (guessesLeft == length) {
                iterate(display);
            }
            else { iterate(displayStatus(guesses, wordArr, display)); }
            System.out.printf("You have %d tries left.\n", guessesLeft);
            while (true) {
                // Combine 37 & 38 into a method
                System.out.println("Enter a single letter: ");
                String guess = scanner.nextLine();
                // Combine 39 - 46 into a method
                if (guess.length() != 1) {
                    System.out.println("Guess must be just one letter!");
                } else if (wasAlreadyGuessed(guesses, guess)) {
                    System.out.println("You already guessed that!");
                } else {
                    guesses[length - guessesLeft] = guess;
                    guessesLeft--;
                    break;
                }
            }
        }
    }

    public static String[] occupyDisplay(int length) {
        String [] display = new String[length];
        Arrays.fill(display, "_");
        return display;
    }

    public static String[] displayStatus(String[] guesses, String[] wordArr, String[] display) {
        for (int i = 0; i < wordArr.length; i++) {
            for (String guess : guesses) {
                if (guess.equals(wordArr[i])) {
                    System.out.println(guess);
                    display[i] = wordArr[i];
                    break;
                }
            }
        }
        return display;
    }

    public static void iterate(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean wasAlreadyGuessed(String[] guesses, String guess) {
        for (String g : guesses) {
            if (guess.equals(g)) {
                return true;
            }
        }
        return false;
    }

    public static String generateWord(ArrayList<String> wordList) {
        Random random = new Random();
        return wordList.get(random.nextInt(wordList.size()));
    }

    public static ArrayList<String> importWords() {
        ArrayList<String> wordList = new ArrayList<>();

        Scanner fileIn;
        try {
            fileIn = new Scanner(new File("/Users/louie/projects/WordGuess/src/main/java/com/github/zipcodewilmington/WordBank.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (fileIn.hasNext())
        {
            String lineIn = fileIn.nextLine();
            wordList.add(lineIn);
        }
        return wordList;
    }
}
