package Ships;

import java.util.Random;
import java.util.random.*;

public abstract class Ship {
    private int health;
    private int attackPower;
    private String shipClass;

    // Constructor
    public Ship(String shipClass, int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
        this.shipClass = shipClass;
    }

    // Getter methods
    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getShipClass() {
        return shipClass;
    }

    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    public void shipAttack(Ship ship) {
        Random rand = new Random();
        int roll = rand.nextInt(20) + 1;

        if (roll > 10) {
            int damage = getAttackPower();
            ship.setHealth(ship.getHealth() - damage);
            System.out.println(getShipClass() + " attacks " + ship.getShipClass() + " for " + damage + " damage.");
        } else {
            System.out.println(getShipClass() + "'s attack misses " + ship.getShipClass() + ".");
        }
    }

    
}
