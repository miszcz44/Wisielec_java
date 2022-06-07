package com.Project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> hangman_Words = Arrays.asList("brbst", "gwegtrwg");

        Random random = new Random();
        String random_word = hangman_Words.get(random.nextInt(hangman_Words.size()));

        System.out.println("Enter how many lives do you want to have:");
        int lifes = scanner.nextInt();
        scanner.nextLine();

        Game game = new Game(lifes, random_word.length(), random_word);

        while(1==1){
            game.setCorrectLetters(0);
            game.PrintTheCurrentStateOfWord(random_word);
            game.checkIfItIsover();
            String letter = scanner.nextLine();
            while(!game.AnalyzeTheLetter(letter)) {
                letter = scanner.nextLine();
            }
            if(random_word.indexOf(letter) == -1){
                System.out.println("Letter not in word");
                game.loseLife();
            }
            else {
                game.addUsedCharacter(letter);
            }
        }
    }
}
