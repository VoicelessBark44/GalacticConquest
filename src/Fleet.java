import java.util.ArrayList;
import java.util.*;

public class Fleet {

    String playerName;

    private ArrayList<Ship> fleet = new ArrayList<>();
    private ArrayList<Ship> CapitalFleet = new ArrayList<>();

    public Fleet() {
        playerName = "none";
    }

    public String getPlayerName(String playerName) {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Fleet(String playerName) {
        getPlayerName(playerName);
    }

    public void removeShip(String shipName) {
        boolean shipFinder = false;
        for (int i = 0; i < fleet.size(); i++) {
            if (fleet.get(i).shipName.equalsIgnoreCase(shipName)) {
                shipFinder = true;
                System.out.println("Removed Ship");
                fleet.remove(i);
            }
        }
        if (shipFinder = false) {
            System.out.println("Ship not found in Fleet.\nNothing removed");
        }
    }

    public int getNumShipsInFleet() {
        return fleet.size();
    }

    public void printShipStats(String shipName) {
        boolean shipFinder = false;
        for (int i = 0; i < fleet.size(); i++) {
            if (fleet.get(i).shipName.equalsIgnoreCase(shipName)) {
                shipFinder = true;
                System.out.println("Ship Name: " + fleet.get(i).shipName +
                        "\nShip Type: " + fleet.get(i).shipType +
                        "\nShip Armour: " + fleet.get(i).armour +
                        "\nShip Speed: " + fleet.get(i).speed +
                        "\nShip Hull Health: " + fleet.get(i).hullHealth +
                        "\nShip Weapon Damage: " + fleet.get(i).weaponDamage);
            }
        }
        if (shipFinder = false) {
            System.out.println("Couldn't find that Ship");
        }
    }

    public void fleetPrinted() {
        for (int i = 0; i < fleet.size(); i++) {
            System.out.println("Size of Fleet: " + fleet.size() +
                    "\nShip Name: " + fleet.get(i).shipName +
                    "\nShip Type: " + fleet.get(i).shipType +
                    "\nShip Armour: " + fleet.get(i).armour +
                    "\nShip Speed: " + fleet.get(i).speed +
                    "\nShip Hull Health: " + fleet.get(i).hullHealth +
                    "\nShip Weapon Damage: " + fleet.get(i).weaponDamage);
        }
    }

    public void addShip(Ship ship) {
        fleet.add(ship);
    }
}