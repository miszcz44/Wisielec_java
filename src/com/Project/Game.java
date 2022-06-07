package com.Project;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Game extends Word {
    private int lives;
    private List<String> used_Characters = new ArrayList();
    private int correctLetters = 0;

    public Game(int lives, int length, String content) {
        super(length, content);
        this.lives = lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void PrintTheCurrentStateOfWord(String content){
            String[] the_Word_Character_By_Character = content.split("");
            for(String letter : the_Word_Character_By_Character){
                if(this.used_Characters.contains(letter)) {
                    System.out.print(letter);
                    this.correctLetters += 1;
                }
                else {
                    System.out.print("_");
                }

            }
        System.out.println();
    }

    public boolean AnalyzeTheLetter(String letter){
        if(letter.length() != 1){
            System.out.println("You need to enter exactly one english alphabet letter. Try again");
            return false;
        }
        else if(Character.isLetter(letter.charAt(0)) == false){
            System.out.println("You need to enter an english alphabet letter. Try again");
            return false;
        }
        else if(this.used_Characters.contains(letter)){
            System.out.println("You already entered this letter. Try again");
            return false;
        }
        return true;
    }

    public void setCorrectLetters(int correctLetters) {
        this.correctLetters = correctLetters;
    }

    public void addUsedCharacter(String letter){
        this.used_Characters.add(letter);
    }

    public int getLives() {
        return lives;
    }

    public boolean checkIfItIsover(){
        if(this.correctLetters == this.content.length()){
            System.out.println("Congratz.");
            return true;
        }
        if(this.lives == 0){
            System.out.println("Bad luck.");
            return true;
        }
        return false;

    }

    public void loseLife(){
        this.lives -= 1;
    }
}
