import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int randomNumber = (int)(Math.random() * 100) + 1;
        int guess;
        int numberOfGuesses = 0;
        int score = 100;
        boolean won = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        while (!won) {
            System.out.print("Enter your guess (1-100): ");
            guess = input.nextInt();
            numberOfGuesses++;
            
            if (guess == randomNumber) {
                won = true;
                System.out.println("You won! The number was " + randomNumber);
                System.out.println("It took you " + numberOfGuesses + " guesses.");
                System.out.println("Your score is " + score);
            } else if (guess < randomNumber) {
                System.out.println("Too low! Guess again.");
                score = score -10;
            } else {
                System.out.println("Too high! Guess again.");
                score = score - 10;
            }
            
        }
    }
}
