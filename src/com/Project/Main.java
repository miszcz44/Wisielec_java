package com.Project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> hangman_Words = Arrays.asList("brbst", "gwegtrwg");

        Random random = new Random();
        String random_word = hangman_Words.get(random.nextInt(hangman_Words.size()));

        System.out.println("Enter how many lives do you want to have:");
        int lives = scanner.nextInt();
        scanner.nextLine();

        Game game = new Game(lives, random_word.length(), random_word);

        while(lives != 0 && game.getCorrectLetters() != random_word.length()){
            game.setCorrectLetters(0);
            game.PrintTheCurrentStateOfWord(random_word);
            String letter = scanner.nextLine();
            while(!game.AnalyzeTheLetter(letter)) {
                letter = scanner.nextLine();
            }
            game.addUsedCharacter(letter);
        }
    }
}
