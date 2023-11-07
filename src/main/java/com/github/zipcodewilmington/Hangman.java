package com.github.zipcodewilmington;


import java.io.File;
import java.io.IOException;
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
        String currentWord = generateWord();

        int length = currentWord.length();
        int guessesLeft = length;
        String[] wordArr = currentWord.split("");
        String[] guesses = new String[length];
        String[] display = occupyDisplay(length);
        System.out.println("Let's Play Wordguess version 1.0");
        while (guessesLeft > 0) {
//            if
            System.out.println("Current Guesses: ");
            if (guessesLeft == length) {
                iterate(display);
            }
            else { iterate(displayStatus(guesses, wordArr, display)); }
            System.out.printf("You have %d tries left.\n", guessesLeft);
            while (true) {
                System.out.println("Enter a single letter: ");
                String guess = scanner.nextLine();
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

    public static String generateWord() {
        // Consider changing to ArrayList<String> so you can remove words easily
        // This would allow for no repeating words if playing multiple games consecutively
        String[] wordList = new String[50];
        Random random = new Random();
        try {
            Scanner fileIn = new Scanner(new File("/Users/louie/projects/WordGuess/src/main/java/com/github/zipcodewilmington/WordBank.txt"));

            int i = 0;
            while (fileIn.hasNext())
            {
                String lineIn = fileIn.nextLine();
                wordList[i] = lineIn;
                i++;
            }
        }
        catch (IOException e) {
            return "File not found.";
        }
        return wordList[random.nextInt(50)];
    }
}
