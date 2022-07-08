package Question4;

import java.util.Scanner;

public class GuessingGameTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GuessingGame game = new GuessingGame();
        String anotherGame = "Y";
        boolean newGame = true;
        //game.GuessingGame();
        while (anotherGame.equals("Y")) {
            System.out.println("Welcome to the Guessing Game");
            System.out.println("Enter the maximum number");
            game.setMax(input.nextInt());
            System.out.println("Enter the number of guesses allowed:");
            game.newGame(input.nextInt());
            while (!game.isGameOver()) {
                System.out.println("Enter your guess, remember it must be between 0 and " + game.getMax());
                game.guess(input.nextInt());
            }
            System.out.println("Would you like to play again, enter Y for yes, N for no");
            anotherGame = input.nextLine();
        }




    }

}
