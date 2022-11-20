public class Ship {

    public String shipType = "";
    public String shipName = "";
    public int armour = 0;
    public int speed = 0;
    public int hullHealth = 0;
    public int weaponDamage = 0;

    public Ship() {

    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHullHealth() {
        return hullHealth;
    }

    public void setHullHealth(int hullHealth) {
        this.hullHealth = hullHealth;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}

class ThisShip extends Ship {

    public ThisShip() {

        this.shipType = "none";
        this.armour = 0;
        this.speed = 0;
        this.hullHealth = 0;
        this.weaponDamage = 0;
        this.shipName = "none";
    }

    public void printShipStats() {
        System.out.println("Ship Name: " + shipName +
                "\nShip Type: " + shipType +
                "\nShip Armour: " + armour +
                "\nShip Speed: " + speed +
                "\nShip Hull Health: " + hullHealth +
                "\nShip Weapon Damage: " + weaponDamage);
    }
}
