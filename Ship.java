public class Ship {
    private int health;
    private int attackPower;

    // Constructor
    public Ship(int health, int attackPower) {
        this.health = health;
        this.attackPower = attackPower;
    }

    // Getter methods
    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
