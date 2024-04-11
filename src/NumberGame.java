import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {


        System.out.println("Welcome to the Number Guessing!");
        System.out.println("You have only 3 attempts to guess");



        //Generate Number
        int min = 0;
        int max = 10;

        Random random = new Random();

        int randomNumber = random.nextInt(max - min + 1) + min;


        Scanner scanner = new Scanner(System.in);

        int attempLeft = 3;

        boolean correctGuess = false;





        while (!correctGuess && attempLeft > 0) {

            // Get Input
            System.out.println("\nEnter a number between 0 and 10: ");

            int guessNumber = scanner.nextInt();

            System.out.println("You Entered : " + guessNumber);

            //Compare

            if (guessNumber == randomNumber) {

                System.out.println("Congratulations! You Guess The Correct Number");
                correctGuess = true;

            } else if (guessNumber > randomNumber) {

                System.out.println("Your Guess is too High, Try Again!");

            } else {

                System.out.println("Your Guess is too Low, Try Again1");
            }

            attempLeft--;


        }

        if (!correctGuess) {
            System.out.println("LOSE THE GAME!");
        }

        scanner.close();

    }

}
