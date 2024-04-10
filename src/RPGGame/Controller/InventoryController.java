package RPGGame.Controller;

import RPGGame.Item.InvItem;

import java.util.ArrayList;

// TODO complete implementation
public class InventoryController {
    ArrayList<InvItem> inventory;
    int size;

    public InventoryController(int size) {
        inventory = new ArrayList<InvItem>();
        this.size = size;
    }
}
