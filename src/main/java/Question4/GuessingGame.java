package Question4;

import java.util.Random;

public class GuessingGame {
    private int answer;
    private Random generator;
    private boolean gameOver;//needs to be a getter
    private int differential;
    private int max;
    private int maxGuessesAllowed;//needs to be a setter
    private int numGuessesTaken;
    private int previousDifferential;

    //Parameterless constructor
    public GuessingGame(){
        setMax(0);
        generator = new Random();
    }
    //Parameterize constructor
    public GuessingGame(int max){
        setMax(max);
        generator = new Random();
    }

    //Initialize parameters when a new game is started
    public void newGame(int maxGuessesAllowed){
        setMaxGuessesAllowed(maxGuessesAllowed);
        answer = getAnswer();
        setGameOver(false);
        setDifferential(getMax());
        setNumGuessesTaken(0);
        setPreviousDifferential(getMax());
    }

    //Display the response once a guess is given
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
                setPreviousDifferential(Math.abs(getDifferential()));
            }
        }else{
            System.out.println("Guess out of range. The guess must be between 0 and " + getMax());
        }
        setNumGuessesTaken(getNumGuessesTaken()+1); //increment the number of guesses taken.
    }
    //determine if the game is over.
    public boolean isGameOver(){
        if (getDifferential()==0){
            return true;
        }else if (getNumGuessesTaken()>=getMaxGuessesAllowed()){
            System.out.println("Exceeded the maximum number of guesses");
            return true;
        }
        else{
            return false;
        }
    }

    //generate the random number
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
