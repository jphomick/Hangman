package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String[] words = {"tree", "rain", "bear", "encourage",
            "promise", "soup", "chess", "insurance", "pancakes", "stream"};

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int guesses = 6;
        String word = words[new Random().nextInt(words.length)];
        ArrayList<String> set = new ArrayList<>();
        ArrayList<String> used = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            set.add("_");
        }

        while (guesses > 0 && set.indexOf("_") != -1) {
            for (int i = 0; i < word.length(); i++) {
                System.out.print(set.get(i) + " ");
            }
            System.out.print("\nGuessed letters: ");
            for (int i = 0; i < used.size(); i++) {
                System.out.print(used.get(i) + " ");
            }
            System.out.println("\nGuesses left: " + guesses + "\nEnter a letter: ");
            String letter = read.nextLine().toLowerCase();
            if (letter.length() == 1) {
                if (word.contains(letter)) {
                    System.out.println(letter + " is in the word!");
                    for (int i = 0; i < word.length(); i++) {
                        if (String.valueOf(word.charAt(i)).equals(letter)) {
                            set.set(i, letter);
                        }
                    }
                } else {
                    System.out.println("Wrong guess!");
                    guesses--;
                }

                if (!used.contains(letter)) {
                    used.add(letter);
                }
            } else if (letter.toLowerCase().equals(word)) {
                break;
            } else {
                System.out.println("Wrong guess!");
                guesses--;
            }
        }

        if (guesses > 0) {
            System.out.println("You've won! The word was " + word + "!");
        } else {
            System.out.println("You lose...");
        }
    }
}
