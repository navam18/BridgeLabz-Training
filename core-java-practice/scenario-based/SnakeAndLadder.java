import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
// Snake and Ladder Game Simulator
// This program simulates the classic Snake and Ladder game with one or two players
public class SnakeAndLadder {
    // Constants for game configuration
    private static final int WINNING_POSITION = 100;
    private static final int START_POSITION = 0;
    private static final int DICE_MIN = 1;
    private static final int DICE_MAX = 6;
    // Game options
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;
    // Player class to represent each player
    static class Player {
        String name;
        int position;
        int diceRollCount;
        Player(String name) {
            this.name = name;
            this.position = START_POSITION;
            this.diceRollCount = 0;
        }
        // Reset player for a new game
        void reset() {
            this.position = START_POSITION;
            this.diceRollCount = 0;
        }
    }
    // Snake and Ladder positions (Key: Start position, Value: End position)
    private static final Map<Integer, Integer> snakes;
    private static final Map<Integer, Integer> ladders;
    static {
        // Initialize snakes (position where player slides down)
        snakes = new HashMap<>();
        snakes.put(99, 54);  snakes.put(95, 75);  snakes.put(93, 73);
        snakes.put(87, 24);  snakes.put(64, 60);  snakes.put(62, 19);
        snakes.put(56, 53);  snakes.put(49, 11);  snakes.put(48, 26);
        snakes.put(16, 6);
        // Initialize ladders (position where player climbs up)
        ladders = new HashMap<>();
        ladders.put(4, 25);   ladders.put(13, 46);  ladders.put(33, 49);
        ladders.put(42, 63);  ladders.put(50, 69);  ladders.put(62, 81);
        ladders.put(74, 92);  ladders.put(80, 99);
    }
    // Random number generator for dice and options
    private static final Random random = new Random();
    // UC1: Roll the dice to get a number between 1 and 6
    private static int rollDice() {
        return random.nextInt(DICE_MAX) + DICE_MIN;
    }
    // UC2: Get the game option (No Play, Ladder, or Snake)
    private static int getOption() {
        return random.nextInt(3); // Returns 0, 1, or 2
    }
    // UC2: Process the player's move based on the dice roll and option
    private static boolean processMove(Player player, int diceValue) {
        int option = getOption();
        int newPosition = player.position;
        boolean extraTurn = false;
        switch(option) {
            case NO_PLAY:
                System.out.println("  Option: No Play - Stay at same position");
                break;
            case LADDER:
                System.out.println("  Option: Ladder - Move ahead by " + diceValue);
                newPosition = player.position + diceValue;
                // UC6: If player gets ladder, they get another turn
                extraTurn = true;
                break;
            case SNAKE:
                System.out.println("  Option: Snake - Move behind by " + diceValue);
                newPosition = player.position - diceValue;
                // UC3: If position goes below 0, restart from 0
                if (newPosition < START_POSITION) {
                    newPosition = START_POSITION;
                }
                break;
        }
        // Check for snakes or ladders at new position
        if (snakes.containsKey(newPosition)) {
            System.out.println("  Oops! Snake at " + newPosition + "! Sliding down to " + snakes.get(newPosition));
            newPosition = snakes.get(newPosition);
        } else if (ladders.containsKey(newPosition)) {
            System.out.println("  Great! Ladder at " + newPosition + "! Climbing up to " + ladders.get(newPosition));
            newPosition = ladders.get(newPosition);
        }
        // UC4: Ensure player doesn't exceed winning position
        if (newPosition > WINNING_POSITION) {
            System.out.println("  Cannot move beyond 100. Staying at position " + player.position);
            newPosition = player.position;
        }
        player.position = newPosition;
        return extraTurn;
    }
    private static boolean playTurn(Player player) {
        System.out.println("\n" + player.name + "'s turn:");
        System.out.println("  Current position: " + player.position);
        // UC1: Roll the dice
        int diceValue = rollDice();
        player.diceRollCount++;
        System.out.println("  Dice rolled: " + diceValue);
        // Process the move
        boolean extraTurn = processMove(player, diceValue);
        // UC5: Report position after dice roll
        System.out.println("  New position: " + player.position);
        System.out.println("  Total dice rolls by " + player.name + ": " + player.diceRollCount);
        // Check if player won
        if (player.position == WINNING_POSITION) {
            System.out.println("\n🎉 " + player.name + " has reached position 100! 🎉");
            return true;
        }
        // UC6: If player got ladder, they get another turn
        if (extraTurn) {
            System.out.println("  " + player.name + " gets another turn because of Ladder!");
            return playTurn(player); // Recursive call for extra turn
        }
        return false;
    }
    // UC3 & UC5: Play game with single player
    private static void playSinglePlayerGame() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STARTING SINGLE PLAYER GAME");
        System.out.println("=".repeat(50));
        Player player = new Player("Player 1");
        while (player.position < WINNING_POSITION) {
            if (playTurn(player)) {
                break;
            }
            // Pause between turns for better readability
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // UC5: Report final statistics
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GAME OVER!");
        System.out.println("Winner: " + player.name);
        System.out.println("Total dice rolls: " + player.diceRollCount);
        System.out.println("=".repeat(50));
    }
    // UC6 & UC7: Play game with two players
    private static void playTwoPlayerGame() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("STARTING TWO PLAYER GAME");
        System.out.println("=".repeat(50));
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player currentPlayer = player1;
        boolean gameWon = false;
        while (!gameWon) {
            System.out.println("\n" + "=".repeat(30));
            // Play current player's turn
            gameWon = playTurn(currentPlayer);
            if (gameWon) {
                break;
            }
            // Switch to next player
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
            // Pause between turns for better readability
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        // UC7: Report which player won
        System.out.println("\n" + "=".repeat(50));
        System.out.println("GAME OVER!");
        System.out.println("Winner: " + currentPlayer.name);
        System.out.println("Player 1 total dice rolls: " + player1.diceRollCount);
        System.out.println("Player 2 total dice rolls: " + player2.diceRollCount);
        System.out.println("=".repeat(50));
    }
    // Display game instructions
    private static void displayInstructions() {
        System.out.println("\n" + "*".repeat(60));
        System.out.println("SNAKE AND LADDER GAME SIMULATOR");
        System.out.println("*".repeat(60));
        System.out.println("\nINSTRUCTIONS:");
        System.out.println("1. Each player starts at position 0");
        System.out.println("2. Roll dice to get a number between 1-6");
        System.out.println("3. Three possible options after dice roll:");
        System.out.println("   - No Play: Stay at same position");
        System.out.println("   - Ladder: Move ahead by dice value (get extra turn)");
        System.out.println("   - Snake: Move behind by dice value");
        System.out.println("4. Land on ladders to climb up");
        System.out.println("5. Avoid snakes or slide down");
        System.out.println("6. First to reach exactly 100 wins!");
        System.out.println("\nLadder positions: " + ladders);
        System.out.println("Snake positions: " + snakes);
        System.out.println("*".repeat(60));
    }
    // Main method to run the game
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        displayInstructions();
        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. Play Single Player Game");
            System.out.println("2. Play Two Player Game");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear invalid input
                continue;
            }
            switch (choice) {
                case 1:
                    playSinglePlayerGame();
                    break;
                case 2:
                    playTwoPlayerGame();
                    break;
                case 3:
                    System.out.println("\nThank you for playing Snake and Ladder!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
            // Ask if user wants to play again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes") && !playAgain.equals("y")) {
                System.out.println("\nThank you for playing Snake and Ladder!");
                break;
            }
        }
    }
}