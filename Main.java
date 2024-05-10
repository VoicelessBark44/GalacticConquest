import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of players:");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter player " + (i + 1) + " name:");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        // Now each player can add ships to their fleets and the game can proceed
        game.start();
    }
}
