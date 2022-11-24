public class Carrier extends Ship{


    public int identifier;
    private String shipType = "Carrier";
    private double hullHealth = 100;
    private int shieldHealth = 30;
    private int armour = 50;
    private double evadeChance = 0.03;
    private double weaponDamage = 120;
    private double repairSpeed = 0.1;
    private boolean Screen = false;
    private boolean Support = false;
    private boolean Capital = true;

    public Carrier() {

    }
}
