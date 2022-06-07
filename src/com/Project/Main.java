package com.Project;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> hangman_Words = Arrays.asList("brbst", "gwegtrwg");
        Random random = new Random();
        String random_word = hangman_Words.get(random.nextInt(hangman_Words.size()));

        Game game = new Game(5, random_word.length(), random_word);

        game.PrintTheCurrentStateOfWord(random_word);
        String letter = scanner.nextLine();
        game.AnalyzeTheLetter(letter);
    }
}
