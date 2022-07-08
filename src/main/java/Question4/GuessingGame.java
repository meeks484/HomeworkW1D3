package Question4;

import org.junit.jupiter.api.Test;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private int answer;
    private Random generator;
    private boolean gameOver;//needs to be a getter
    private int differential;
    private int max;
    private int maxGuessesAllowed;//needs to be a setter
    private int numGuessesTaken;
    private int previousDifferential;

    public GuessingGame(){
        setMax(0);
        generator = new Random();
    }

    public GuessingGame(int max){
        setMax(max);
        generator = new Random();
    }

    public void newGame(int maxGuessesAllowed){
        setMaxGuessesAllowed(maxGuessesAllowed);
        answer = getAnswer();
        setGameOver(false);
        setDifferential(getMax());
        setNumGuessesTaken(0);
    }

    public void guess(int guessIn){
        setDifferential(guessIn-answer);
        if (guessIn < getMax()){
            if (getDifferential() == 0){
                System.out.println("Congratulation");
            }else {
                if (getDifferential() > 0) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
                if (getDifferential() < getPreviousDifferential()) {
                    System.out.println("Getting Warmer");
                } else {
                    System.out.println("Getting Colder");
                }
                setPreviousDifferential(getDifferential());
            }
        }else{
            System.out.println("Guess out of range. The guess must be between 0 and " + getMax());
        }
        setNumGuessesTaken(getNumGuessesTaken()+1);
    }
    public boolean isGameOver(){
        if (getNumGuessesTaken()>getMaxGuessesAllowed() || getDifferential()==0){
            return true;
        }else{
            return false;
        }
    }
    private int getRandomNumber(int range){
        return generator.nextInt(range);
    }

    //Setters and Getters for all instance variables
    public int getAnswer() {
        return answer = getRandomNumber(getMax());
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public void setDifferential(int differential) {
        this.differential = differential;
    }
    public int getDifferential() {
        return differential;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setMaxGuessesAllowed(int maxGuessesAllowed) {
        this.maxGuessesAllowed = maxGuessesAllowed;
    }
    public int getMaxGuessesAllowed() {
        return maxGuessesAllowed;
    }
    public void setNumGuessesTaken(int numGuessesTaken) {
        this.numGuessesTaken = numGuessesTaken;
    }
    public int getNumGuessesTaken() {
        return numGuessesTaken;
    }
    public void setPreviousDifferential(int previousDifferential) {
        this.previousDifferential = previousDifferential;
    }
    public int getPreviousDifferential() {
        return previousDifferential;
    }
}
