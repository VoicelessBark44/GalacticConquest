public class Ship {


    public int identifier;
    private String shipType = "";
    private double hullHealth = 0;
    private int shieldHealth = 0;
    private int armour = 0;
    private double evadeChance = 0;
    private double weaponDamage = 0;
    private double repairSpeed = 0;
    private boolean Screen = false;
    private boolean Support = false;
    private boolean Capital = false;

    public Ship(String shipType, double hullHealth, int shieldHealth, int armour, double evadeChance, double weaponDamage, double repairSpeed) {
        this.shipType = shipType;
        this.hullHealth = hullHealth;
        this.shieldHealth = shieldHealth;
        this.armour = armour;
        this.evadeChance = evadeChance;
        this.weaponDamage = weaponDamage;
        this.repairSpeed = repairSpeed;
    }

    public Ship() {

    }

    public double getRepairSpeed() {
        return repairSpeed;
    }

    public void setRepairSpeed(double repairSpeed) {
        this.repairSpeed = repairSpeed;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public double getHullHealth() {
        return hullHealth;
    }

    public void setHullHealth(double hullHealth) {
        this.hullHealth = hullHealth;
    }

    public int getShieldHealth() {
        return shieldHealth;
    }

    public void setShieldHealth(int shieldHealth) {
        this.shieldHealth = shieldHealth;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public double getEvadeChance() {
        return evadeChance;
    }

    public void setEvadeChance(double evadeChance) {
        this.evadeChance = evadeChance;
    }

    public double getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public void lowerHealth(double damage) {
        hullHealth =-damage;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "shipType='" + shipType + '\'' +
                ", hullHealth=" + hullHealth +
                ", shieldHealth=" + shieldHealth +
                ", armour=" + armour +
                ", evadeChance=" + evadeChance +
                ", weaponDamage=" + weaponDamage +
                ", repairSpeed=" + repairSpeed +
                '}';
    }
}
