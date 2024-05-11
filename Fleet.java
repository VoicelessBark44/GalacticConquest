import java.util.ArrayList;
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

    public void attack(Fleet enemyFleet) {
        // Logic for attacking the enemy fleet
    }

    public List<Ship> getShips() {
        return ships;
    }
}
