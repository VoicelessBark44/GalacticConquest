import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;


import Ships.*;

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
                Player opponent = chooseOpponent(player);
                if (opponent != null) {
                    player.getFleet().attack(opponent.getFleet());
                }
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

    public Player chooseOpponent(Player currentPlayer) {
        // Display available opponents
        System.out.println("Choose an opponent to attack:");

        int index = 1;
        for (Player opponent : players) {
            if (!opponent.equals(currentPlayer)) {
                System.out.println(index + ". " + opponent.getName());
                index++;
            }
        }

        // Get user's choice for opponent
        int choiceIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Validate and return the selected opponent
        if (choiceIndex >= 1 && choiceIndex <= players.size() - 1) {
            return players.get(choiceIndex - 1); // Adjust index to match list index
        } else {
            System.out.println("Invalid opponent choice.");
            return null;
        }
    }

    private void addShipToPlayerFleet(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Adding Ships to " + player.getName() + "'s Fleet ===");
    
        while (true) {
            // Display ship options
            System.out.println("Choose a ship type:");
            System.out.println("1. Fighter");
            System.out.println("2. Corvette");
            System.out.println("3. Frigate");
            System.out.println("4. Destroyer");
            System.out.println("5. Cruiser");
            System.out.println("6. Battleship");
            System.out.println("7. Titan");
            System.out.println("8. Giant");
            // Add other ship types here
            
            // Get user's choice for ship type
            int shipChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            // Get ship type based on user's choice
            Ship newShip;
            switch (shipChoice) {
                case 1:
                    newShip = new Fighter();
                    break;
                case 2:
                    newShip = new Corvette();
                    break;
                case 3:
                    newShip = new Frigate();
                    break;
                case 4:
                    newShip = new Destroyer();
                    break;
                case 5:
                    newShip = new Cruiser();
                    break;
                case 6:
                    newShip = new Battleship();
                    break;
                case 7:
                    newShip = new Titan();
                    break;
                case 8:
                    newShip = new Giant();
                    break;
                    // Add cases for other ship types here
                default:
                    System.out.println("Invalid ship type choice. Ship not added to fleet.");
                    return;
            }
            
            // Prompt user to enter quantity
            System.out.println("Enter the quantity of " + newShip.getShipClass() + " to add to the fleet (0 to cancel):");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (quantity == 0) {
                break; // Exit loop if user cancels
            }
            
            // Add the specified quantity of the chosen ship type to the player's fleet
            for (int i = 0; i < quantity; i++) {
                player.addShipToMyFleet(newShip);
            }
            
            System.out.println("Added " + quantity + " " + newShip.getShipClass() + "(s) to " + player.getName() + "'s fleet.");
            System.out.println("Do you want to add more ships? (yes/no)");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break; // Exit loop if user does not want to add more ships
            }
        }
    }
    

    private void displayPlayerFleet(Player player) {
        System.out.println("=== " + player.getName() + "'s Fleet ===");
        Fleet fleet = player.getFleet();
        List<Ship> ships = fleet.getShips();
    
        if (ships.isEmpty()) {
            System.out.println("Your fleet is empty.");
        } else {
            // Create maps to store the count, total health, and total attack power of each ship type
            Map<String, Integer> shipCounts = new HashMap<>();
            Map<String, Integer> totalHealth = new HashMap<>();
            Map<String, Integer> totalAttackPower = new HashMap<>();
    
            // Iterate over the fleet and calculate metrics
            for (Ship ship : ships) {
                String shipType = ship.getShipClass();
                int health = ship.getHealth();
                int attackPower = ship.getAttackPower();
    
                // Update ship counts
                shipCounts.put(shipType, shipCounts.getOrDefault(shipType, 0) + 1);
    
                // Update total health and total attack power for each ship type
                totalHealth.put(shipType, totalHealth.getOrDefault(shipType, 0) + health);
                totalAttackPower.put(shipType, totalAttackPower.getOrDefault(shipType, 0) + attackPower);
            }
    
            // Calculate averages and display information
            int totalShips = ships.size();
            int totalFleetHealth = ships.stream().mapToInt(Ship::getHealth).sum();
            int totalFleetAttackPower = ships.stream().mapToInt(Ship::getAttackPower).sum();
    
            System.out.printf("%-20s %-10s%n", "Total ships:", totalShips);
            System.out.printf("%-20s %-10s%n", "Total fleet health:", totalFleetHealth);
            System.out.printf("%-20s %-10s%n", "Total fleet attack power:", totalFleetAttackPower);
            System.out.printf("%-20s %-10s%n", "Average fleet health:", (double) totalFleetHealth / totalShips);
            System.out.printf("%-20s %-10s%n", "Average fleet attack power:", (double) totalFleetAttackPower / totalShips);
    
            // Display ship type-wise information
            System.out.println();
            System.out.println("Ship Type            | Number of Ships | Average Health | Average Attack Power");
            System.out.println("---------------------|-----------------|----------------|---------------------");
            for (Map.Entry<String, Integer> entry : shipCounts.entrySet()) {
                String shipType = entry.getKey();
                int count = entry.getValue();
                int avgHealth = totalHealth.get(shipType) / count;
                int avgAttackPower = totalAttackPower.get(shipType) / count;
    
                System.out.printf("%-20s %-17s %-15s %-20s%n", shipType, count, avgHealth, avgAttackPower);
            }
        }
    }
    
    
    

    private boolean isGameOver() {
        // Implement game over condition
        // Example: If any player's fleet is destroyed
        return false;
    }
}