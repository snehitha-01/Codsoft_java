import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int maxRounds = 3;
        int totalScore = 0;

        for (int round = 1; round <= maxRounds; round++) {
            // Generate a random number within the specified range for each round
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            System.out.println("Welcome to Round " + round + " of the Number Guessing Game!");
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            } else {
                int roundScore = maxAttempts - attempts + 1;
                totalScore += roundScore;
                System.out.println("You guessed the number in " + attempts + " attempts in Round " + round + "!");
                System.out.println("Round Score: " + roundScore);
            }

            // Ask if the user wants to play another round
            if (round < maxRounds) {
                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgain = scanner.nextLine().toLowerCase();

                if (!playAgain.equals("yes")) {
                    System.out.println("Game Over. Your total score: " + totalScore);
                    break;
                }
            }
        }

        scanner.close();
    }
}
