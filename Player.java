public class Player {
    private String name;
    private Fleet fleet;

    public Player(String name) {
        this.name = name;
        fleet = new Fleet();
    }

    public String getName() {
        return name;
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void addShipToMyFleet(Ship ship) {
        fleet.addShip(ship);
    }
}
