import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Scanner scanner;
    private int currentPlayerIndex;

    public Game() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        currentPlayerIndex = 0; // Start with the first player
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void start() {
        while (!isGameOver()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");

            // Perform actions for the current player
            currentPlayerTurn(currentPlayer);

            // Move to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }

        // Display game result
        System.out.println("Game Over!");
    }

    public void currentPlayerTurn(Player player) {

        // System.out.print("\033[H\033[2J");
        // System.out.flush();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== " + player.getName() + "'s Turn ===");
        System.out.println("Choose an action:");
        System.out.println("1. Add a ship to your fleet");
        System.out.println("2. Attack opponent's fleet");
        System.out.println("3. See your ships and their stats");
        System.out.println("4. Pass turn to the next player");
        System.out.println("Q. Quit");
    
        String choice = scanner.nextLine();
    
        switch (choice.toUpperCase()) {
            case "1":
                addShipToPlayerFleet(player);
                break;
            case "2":
                // Logic to attack opponent's fleet
                System.out.println("You chose to attack the opponent's fleet.");
                break;
            case "3":
                displayPlayerFleet(player);
                break;
            case "4":
                System.out.println("Passing turn to the next player.");
                return; // Exit the method without changing currentPlayerIndex
            case "Q":
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0); // Terminate the program
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    
        // If the player didn't pass the turn, increment currentPlayerIndex
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private void addShipToPlayerFleet(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Adding Ship to " + player.getName() + "'s Fleet ===");
    
        // Prompt user to enter ship details
        System.out.println("Enter ship health:");
        int shipHealth = scanner.nextInt();
        System.out.println("Enter ship attack power:");
        int shipAttackPower = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create a new ship with the entered details
        Ship newShip = new Ship(shipHealth, shipAttackPower);
        
        // Add the new ship to the player's fleet
        player.addShipToMyFleet(newShip);
        
        System.out.println("Ship added to " + player.getName() + "'s fleet.");
    }
    
    private void displayPlayerFleet(Player player) {
        System.out.println("=== " + player.getName() + "'s Fleet ===");
        Fleet fleet = player.getFleet();
        List<Ship> ships = fleet.getShips();
        if (ships.isEmpty()) {
            System.out.println("Your fleet is empty.");
        } else {
            for (Ship ship : ships) {
                System.out.println("Health: " + ship.getHealth());
                System.out.println("Attack Power: " + ship.getAttackPower());
                System.out.println();
            }
        }
    }

    private boolean isGameOver() {
        // Implement game over condition
        // Example: If any player's fleet is destroyed
        return false;
    }
}