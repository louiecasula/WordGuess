package com.github.zipcodewilmington;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Procedural {
//    public static void main(String [] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> wordList = importWords();
//        String currentWord = generateWord(wordList);
//
//        int length = currentWord.length();
//        int guessesLeft = length;
//        String[] wordArr = currentWord.split("");
//        String[] guesses = new String[length];
////        ArrayList<String> guesses = new ArrayList<>();
//        String[] display = occupyDisplay(length);
//        System.out.println("Let's Play Wordguess version 1.0");
//        while (guessesLeft > 0) {
//            // Include a boolean that determines if whole word has been guessed.
//            System.out.println("Current Guesses: ");
//            if (guessesLeft == length) {
//                iterate(display);
//            }
//            else { iterate(displayStatus(guesses, wordArr, display)); }
//            System.out.printf("You have %d tries left.\n", guessesLeft);
//            while (true) {
//                String guess = promptUser("Enter a single character: ");
//                // Combine 39 - 46 into a method
//                if (guess.length() != 1) {
//                    System.out.println("Guess must be just one letter!");
//                } else if (wasAlreadyGuessed(guesses, guess)) {
//                    System.out.println("You already guessed that!");
//                } else {
//                    guesses[length - guessesLeft] = guess;
//                    guessesLeft--;
//                    break;
//                }
//            }
//        }
//    }
//
//    public static String promptUser(String prompt) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(prompt);
//        return scanner.nextLine();
//    }
//
//    public static boolean isValidGuess(String guess, ) {
//        public static boolean wasAlreadyGuessed(ArrayList<String> guesses) {
//            if (guess.length() != 1) {
//                System.out.println("Guess must be just one letter!");
//            } else if (wasAlreadyGuessed(guesses, guess)) {
//                System.out.println("You already guessed that!");
//            } else {
//                guesses[length - guessesLeft] = guess;
//                guessesLeft--;
//                return true;
//            }
//        }
//
//
//        public static String[] occupyDisplay ( int length){
//            String[] display = new String[length];
//            Arrays.fill(display, "_");
//            return display;
//        }
//
//        public static String[] displayStatus (String[]guesses, String[]wordArr, String[]display){
//            for (int i = 0; i < wordArr.length; i++) {
//                for (String guess : guesses) {
//                    if (guess.equals(wordArr[i])) {
//                        System.out.println(guess);
//                        display[i] = wordArr[i];
//                        break;
//                    }
//                }
//            }
//            return display;
//        }
//
//        public static void iterate (String[]array){
//            for (int i = 0; i < array.length; i++) {
//                System.out.print(array[i] + " ");
//            }
//            System.out.println();
//        }
//
//        (String[]guesses, String guess){
//            for (String g : guesses) {
//                if (guess.equals(g)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//
//        public static String generateWord (ArrayList < String > wordList) {
//            Random random = new Random();
//            return wordList.get(random.nextInt(wordList.size()));
//        }
//
//        public static ArrayList<String> importWords(String pathname) {
//            ArrayList<String> wordList = new ArrayList<>();
//
//            Scanner fileIn;
//            try {
//                fileIn = new Scanner(new File());
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//
//            while (fileIn.hasNext()) {
//                String lineIn = fileIn.nextLine();
//                wordList.add(lineIn);
//            }
//            return wordList;
//        }
//    }
}
