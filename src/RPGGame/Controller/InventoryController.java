package RPGGame.Controller;

import RPGGame.Item.Abstracts.*;

import java.util.ArrayList;

// TODO complete implementation
public class InventoryController {
    ArrayList<InvItem> inventory;
    public WeaponItem weapon;
    public HeadItem headwear;
    public ChestItem chestwear;
    public LegItem legwear;
    public RingItem ring;
    int size;

    public InventoryController(int size) {
        inventory = new ArrayList<InvItem>();
        this.size = size;
    }

    //TODO: Please make this better, I hate this
    public void equip(EquipabbleItem newItem) {
        EquipabbleItem oldItem = null;
        if (newItem instanceof WeaponItem) {
            oldItem = weapon;
            weapon = (WeaponItem)newItem;
        } else if (newItem instanceof HeadItem) {
            oldItem = headwear;
            headwear = (HeadItem)newItem;
        } else if (newItem instanceof ChestItem) {
            oldItem = chestwear;
            chestwear = (ChestItem) newItem;
        } else if (newItem instanceof LegItem) {
            oldItem = legwear;
            legwear = (LegItem) newItem;
        } else if (newItem instanceof RingItem) {
            oldItem = ring;
            ring = (RingItem) newItem;
        }
        if (oldItem != null) {
            oldItem.onUnequip();
        }
        newItem.onEquip();
    }

    public void addItem(InvItem item){
        if (inventory.size() < size) {
            inventory.add(item);
        } else {
            SceneController.gameTextAreaNewLine("Inventory Full");
        }
    }

    //TODO: Implement
    public void unequip() {

    }
}
