import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type \"Quit\" to exit.");
        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerMove = scan.nextLine();
        int playerCounter = 0;
        int comCounter = 0;
        while (!playerMove.equals("Quit")) {
            if (playerMove.equals("r") || playerMove.equals("rock")) {
                playerMove = ROCK;
            } else if (playerMove.equals("p") || playerMove.equals("paper")) {
                playerMove = PAPER;
            } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
                playerMove = SCISSORS;
            } else {
                System.out.println("Invalid Input. Try Again...");
                return;
            }
            Random random = new Random();
            int computerRandomNumber = random.nextInt(3);
            String computerMove = "";
            switch (computerRandomNumber) {
                case 0:
                    computerMove = ROCK;
                    break;
                case 1:
                    computerMove = PAPER;
                    break;
                case 2:
                    computerMove = SCISSORS;
                    break;
            }
            System.out.printf("The computer chose %s.%n", computerMove);

            if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))) {
                playerCounter++;
                System.out.println("You win.");
            } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
                comCounter++;
                System.out.println("You lose.");
            } else {
                System.out.println("This game was a draw.");
            }
            System.out.println("Choose [r]ock, [p]aper or [s]cissors: ");
            playerMove = scan.nextLine();
        }
        System.out.printf("Player score: %d%n", playerCounter);
        System.out.printf("Computer score: %d", comCounter);

    }
}