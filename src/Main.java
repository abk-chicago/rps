import java.util.*;
import java.io.*;
import java.lang.Exception.*;

// source disclosure:  http://stackoverflow.com/questions/19204872/rock-paper-scissors-game-java

public class Main {

    static ArrayList<String> gameHistory = new ArrayList<>();

    public static void main(String[] args) {
        mainMenu();
    }

    static void mainMenu() {
        try {   // intro to the game and user prompt

            System.out.println("Welcome to Andrea's \"Rock, Paper, Scissors\" Game!");
            System.out.println("Please choose one of the following options:");
            System.out.println("Type 1 to play or 2 for game history:");
            System.out.println("Enter your choice here: ");
            Scanner reader = new Scanner(System.in);
            int choice = reader.nextInt();
            // interpret the user input below:
            if (choice == 1) {
                System.out.println("Here we go!");
                runGame();
            } else if (choice == 2) {
                System.out.println("Your game history: " + gameHistory);
                showHistory();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please start over. Choices available are 1 or 2");
        }
        return;

    }

    public static void runGame() {
        String youWon = "You won.";
        String youLost = "You lost.";
        String tieGame = "Tie game.";

        String result = null;
        System.out.println("Please enter your move.\n" + "Rock = R, Paper" +
                "= P, and Scissors = S.");
        String humanChoice; //User's choice -- "R", "P", or "S"
        Character computerChoice = null; //Computer's choice -- "R", "P", or "S"
        int computerInt; //Randomly generated number used to determine computer's choice
        String response;

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();

        //Generate computer's choice)
        computerInt = generator.nextInt(3) + 1;

        //Translate computer's randomly generated play to string using if statements
        if (computerInt == 1)
            computerChoice = 'R';
        else if (computerInt == 2)
            computerChoice = 'P';
        else if (computerInt == 3)
            computerChoice = 'S';

        //Get player's choice from input-- note that this is stored as a string
        System.out.println("Enter your choice (R, P or S): ");
        humanChoice = scan.nextLine();

        //Make player's choice uppercase for ease of comparison
        humanChoice = humanChoice.toUpperCase();

        //Print computer's choice
        System.out.println("Computer choice is: " + computerChoice);

        //See who won.

        if (humanChoice.equals(String.valueOf(computerChoice))) {
            System.out.println("It's a tie!");
            result = tieGame;
            gameHistory.add(result);

        } else if (humanChoice.equals("R") && computerChoice.equals('S')) {
            result = youWon;
            gameHistory.add(result);
            System.out.println("Rock breaks scissors. You win!!");
        } else if (humanChoice.equals("R") && computerChoice.equals('P')) {
            result = youLost;
            gameHistory.add(result);
            System.out.println("Paper wraps rock. You lose!!");
        } else if (humanChoice.equals("P") && computerChoice.equals('S')) {
            result = youLost;
            gameHistory.add(result);
            System.out.println("Scissor cuts paper. You lose!!");
        } else if (humanChoice.equals("P") && computerChoice.equals('R')) {
            result = youWon;
            gameHistory.add(result);
            System.out.println("Paper wraps rock. You win!!");
        } else if (humanChoice.equals("S") && computerChoice.equals('P')) {
            result = youWon;
            gameHistory.add(result);
            System.out.println("Scissor cuts paper. You win!!");
        } else if (humanChoice.equals("S") && computerChoice.equals('R')) {
            result = youLost;
            gameHistory.add(result);
            System.out.println("Rock breaks scissors. You lose!!");
        } else {
            System.out.println("Invalid user input.");
        }


        System.out.println("Would you like to play again?");

        String newString = null;
        Scanner scan1 = new Scanner(System.in);
        newString = scan1.next();


        if (Objects.equals(newString, "y")) {   // note to self: remember this!!

            mainMenu();
        } else {
            System.out.println("Bye!");
        }
        return;

    }

    private static void showHistory() {

            if (gameHistory.isEmpty()) {
                System.out.println("There is currently no history to display.");
            } else {
                for (int i = 0; i < gameHistory.size(); i++) {
                    System.out.println(gameHistory.get(i));
                }
            }

        }
    }
