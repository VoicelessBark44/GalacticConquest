import java.util.*;

public class FleetManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean work = true;
        Fleet firstFleet = new Fleet();
        System.out.println("Fleet Name: ");
        firstFleet.fleetName = sc.nextLine();
        while (work) {
            mainMenu();
            String selection = sc.next();

            if (selection.equalsIgnoreCase("a")) {
                System.out.println("Add a Ship to Fleet");
                System.out.println("A - Destroyer" +
                                    "\nB - Cruiser" +
                                    "\nC - BattleShip" +
                                    "\nD - Carrier");
                String shipChoice = sc.next();
                if (shipChoice.equalsIgnoreCase("a")) {
                    destroyer destroyerOne = new destroyer();
                    firstFleet.addShip(destroyerOne);
                } else if (shipChoice.equalsIgnoreCase("b")) {
                    Cruiser cruiserOne = new Cruiser();
                    firstFleet.addShip(cruiserOne);
                } else if (shipChoice.equalsIgnoreCase("c")) {
                    BattleShip battleOne = new BattleShip();
                    firstFleet.addShip(battleOne);
                } else if (shipChoice.equalsIgnoreCase("d")) {
                    Carrier carrierOne = new Carrier();
                    firstFleet.addShip(carrierOne);
                }
            } else if (selection.equalsIgnoreCase("r")){
                System.out.println("Remove a Ship from the Fleet");
                System.out.println("Enter Ship Identifier: ");
            } else if (selection.equalsIgnoreCase("q")) {
                System.out.println("You are Exiting");
                work = false;
            }

        }
    }

    public static void mainMenu() {
        System.out.println("""
                Menu
                A - Add Ship to Fleet
                R - Remove a Ship from Fleet
                Q - Quit
                """);
    }
}