/*
 * This Java program implements a Number Guessing Game. 
 * Users can play the game by guessing a randomly generated number within a specified range.
 * The range always begins from 1 and the user has to provide the ending number. 
 * For example, if the user enters 20, the range will be from 1 to 20. 
 * The program provides feedback (higher or lower) after each guess and keeps track of the number of tries.
 * Users can also view their scoreboard to see their best and all scores for the session.
 */



import java.util.*;
public class NumberGuessingGame {
    // ArrayList to store scores (number of tries)
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();
    public static void main(String[] args) {
         // Create an instance of the class and call the menu function
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }
     // Menu function that displays options and handles user choices
    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
         // Scanner object to read user input
        Scanner input = new Scanner(System.in); 
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Welcome to the Number Gussing Game!");
        System.out.println("1. Play the Game");
        System.out.println("2. Score Board");
        System.out.println("3. Exit the game");
        System.out.println("--------------------------------------------------------------------------------");
        try {
            System.out.print("What you want to do from the above options ( 1 / 2 / 3 ) ? ---> ");
            int menuOption = input.nextInt(); // Read user choice
            switch (menuOption) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ---> ");
                    int numberRange = input.nextInt();
                    int randomNumber = methodChange.randomNumber(numberRange);
                    methodChange.guessNumber(randomNumber);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thank you for playing!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry. Please try again...");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+"Invalid number entry. Please try again."+"\n");
            menu(scoreBoard);
        }
    }
    // Function to generate a random number within a specified range
    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }
     // Function to handle the guessing game logic
    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("What's your guess? Enter here: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower...");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher...");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");

        menu(scoreBoard);
    }
    // function to display the scoreboard
    public void displayScoreBoard() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Score Board ---> ");
        System.out.println("------------");
        Collections.sort(scoreBoard);
        System.out.println("Your fastest game score today out of all tries is: " + scoreBoard.get(0) + " !!" + "\n");
        System.out.println("All scores ---> ");
        System.out.println("-----------");
        for (Integer scores : scoreBoard) {
            System.out.println("In this attempt you finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(scoreBoard);
    }
}