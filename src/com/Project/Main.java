package com.Project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> hangman_Words = Arrays.asList("brbst", "gwegtrwg");
        List<String> hangman_Words_Modifiable = new ArrayList<>(hangman_Words);

        while(1==1){
            Random random = new Random();
            String random_word = hangman_Words_Modifiable.get(random.nextInt(hangman_Words_Modifiable.size()));
            hangman_Words_Modifiable.remove(random_word);
            System.out.println("1.Play\n2.Exit");
            int userChoice = scanner.nextInt();
            if(userChoice == 2){
                break;
            }

            System.out.println("Enter how many lives do you want to have:");
            int lifes = scanner.nextInt();
            scanner.nextLine();

            Game game = new Game(lifes, random_word.length(), random_word);

            while (1 == 1) {
                game.setCorrectLetters(0);
                game.PrintTheCurrentStateOfWord(random_word);

                if (game.checkIfItIsover()) {
                    break;
                }

                String letter = scanner.nextLine();
                while (!game.AnalyzeTheLetter(letter)) {
                    letter = scanner.nextLine();
                }

                if (random_word.indexOf(letter) == -1) {
                    System.out.println("Letter not in word");
                    game.loseLife();
                } else {
                    game.addUsedCharacter(letter);
                }

            }
        }
    }
}
