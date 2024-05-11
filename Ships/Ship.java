package Ships;
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

    
}
