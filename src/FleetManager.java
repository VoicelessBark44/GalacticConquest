import java.util.*;


public class FleetManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");


        boolean main = true;
        while (main) {

            printMainMenu();

            String sel = sc.next();
            if (sel.equalsIgnoreCase("a")) {
                System.out.println("Enter Player Name: ");
                String playerName = sc.next();
                Fleet oneFleet = new Fleet(playerName);
                System.out.println();

                boolean work = true;
                while (work) {
                    printMenu();

                    ThisShip shipOne = new ThisShip();
                    String selection = sc.next();

                    if (selection.equalsIgnoreCase("a")) {
                        System.out.println("Add Ship to Fleet\n"
                                + "Enter the ship name: ");
                        sc.nextLine();
                        shipOne.setShipName(sc.nextLine());
                        System.out.println("Enter the Ship Type: ");
                        shipOne.setShipType(sc.next());
                        System.out.println("Enter the ship armour: ");
                        shipOne.setArmour(sc.nextInt());
                        System.out.println("Enter the ship's speed: ");
                        shipOne.setSpeed(sc.nextInt());
                        System.out.println("Enter the ship's hull health: ");
                        shipOne.setHullHealth(sc.nextInt());
                        System.out.println("Enter the ship's weapon damage: ");
                        shipOne.setWeaponDamage(sc.nextInt());
                        oneFleet.addShip(shipOne);
                        sc.nextLine();
                    } else if (selection.equalsIgnoreCase("r")) {
                        System.out.println("Remove a ship from the Fleet\n" +
                                "Enter the Ship to remove: ");
                        oneFleet.removeShip(sc.nextLine());
                    } else if (selection.equalsIgnoreCase("s")) {
                        System.out.println("Output a Ship's Stats\n" +
                                "Enter the Ship to find: ");
                        oneFleet.printShipStats(sc.next());
                    } else if (selection.equalsIgnoreCase("o")) {
                        System.out.println("Output a Fleet's Stats\n");
                        oneFleet.fleetPrinted();
                    } else if (selection.equalsIgnoreCase("q")) {
                        System.out.println("In service of the God Emperor of Mankind");
                        sc.nextLine();
                        work = false;
                    }
                }
            } else if (sel.equalsIgnoreCase("q")) {
                System.out.println("For the God Emperor of Mankind!");
                main = false;
            }
        }
    }

    public static void printMenu () {
        System.out.println("MENU\n"
                + "a - Add a ship to fleet\n"
                + "r - Remove a ship from fleet\n"
                + "s - Output a ship's Stats\n"
                + "o - Output Total Fleet Stats of Ships\n"
                + "q - Quit");
    }

    public static void printMainMenu () {
        System.out.println("Welcome to Galactic Conquest Fleet Combat Tracker!\n"
                + "a - PlayerOne's Fleet\n"
                + "b - PlayerTwo's Fleet\n"
                + "c - PlayerThree's Fleet\n"
                + "d - PlayerFour's Fleet\n"
                + "q - Quit");
    }

}
