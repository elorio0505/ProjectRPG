package RPGGame.Entity;

import RPGGame.Controller.InventoryController;

// TODO complete implementation
public class Player extends Entity {
    final int DEFAULT_INVENTORY_SIZE = 8;

    InventoryController inv;
    public String name;

    public Player(String name) {
        this.name = name;
        inv = new InventoryController(DEFAULT_INVENTORY_SIZE);
    }

    // Stat Definitions
    @Override
    public int maxLifeValue() {return 0;}

    @Override
    public int physAttackValue() {return 0;}

    @Override
    public int specAttackValue() {return 0;}

    @Override
    public int physDefenseValue() {return 0;}

    @Override
    public int specDefenseValue() {return 0;}

    @Override
    public int speedValue() {return 0;}

    @Override
    public int luckValue() {return 0;}

}
