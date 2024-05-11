import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Ships.Ship;

public class Fleet {
    private List<Ship> ships;

    public Fleet() {
        ships = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void removeShip(Ship ship) {
        ships.remove(ship);
    }

    // public void attack(Fleet enemyFleet) {
    //     // Determine the number of ships the attacking fleet can target
    //     int maxTargets = Math.min(ships.size(), enemyFleet.getShips().size());

    //     // Sort enemy fleet by health (weakest ships first)
    //     enemyFleet.getShips().sort(Comparator.comparingInt(Ship::getHealth));

    //     // Attack each ship in the enemy fleet
    //     for (int i = 0; i < maxTargets; i++) {
    //         Ship attackingShip = ships.get(i);
    //         Ship defendingShip = enemyFleet.getShips().get(i);

    //         // Reduce defending ship's health by attacking ship's attack power
    //         int damage = attackingShip.getAttackPower();
    //         int remainingHealth = Math.max(defendingShip.getHealth() - damage, 0);
    //         defendingShip.setHealth(remainingHealth);

    //         System.out.println(attackingShip.getShipClass() + " attacks " + defendingShip.getShipClass() + " for " + damage + " damage.");
    //         System.out.println(defendingShip.getShipClass() + " has " + remainingHealth + " health remaining.");

    //         // Check if defending ship is destroyed
    //         if (remainingHealth == 0) {
    //             System.out.println(defendingShip.getShipClass() + " has been destroyed!");
    //             enemyFleet.removeShip(defendingShip);
    //         }

    //         // Check if defending fleet is destroyed
    //         if (enemyFleet.getShips().isEmpty()) {
    //             System.out.println("Enemy fleet has been destroyed!");
    //             break; // End combat if defending fleet is destroyed
    //         }
    //     }
    // }

    public void attack(Fleet enemyFleet) {
        int maxTargets = Math.min(ships.size(), enemyFleet.getShips().size());

        //Weakest to strongest
        //enemyFleet.getShips().sort(Comparator.comparingInt(Ship::getHealth));
        
    }
    
    

    public List<Ship> getShips() {
        return ships;
    }
}