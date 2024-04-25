package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Item.Abstracts.*;
import RPGGame.Item.Abstracts.Helper.EquipmentType;

import java.util.ArrayList;

// TODO complete implementation
public class InventoryController {
    ArrayList<InvItem> inventory;
    Player owner;
    public WeaponItem weapon;
    public EquippableItem headwear;
    public EquippableItem chestwear;
    public EquippableItem legwear;
    public EquippableItem ring;
    int size;

    public InventoryController(Player owner, int size) {
        inventory = new ArrayList<InvItem>();
        this.owner = owner;
        this.size = size;
    }

    //TODO: Please make this better, I hate this
    public void equip(EquippableItem newItem) {
        EquippableItem oldItem = null;
        if (newItem instanceof WeaponItem) {
            oldItem = weapon;
            weapon = (WeaponItem)newItem;
        } else if (newItem.GetType() == EquipmentType.HEAD) {
            oldItem = headwear;
            headwear = newItem;
        } else if (newItem.GetType() == EquipmentType.BODY) {
            oldItem = chestwear;
            chestwear = newItem;
        } else if (newItem.GetType() == EquipmentType.LEGS) {
            oldItem = legwear;
            legwear = newItem;
        } else if (newItem.GetType() == EquipmentType.RING) {
            oldItem = ring;
            ring = newItem;
        }
        if (oldItem != null) {
            oldItem.onUneuip(owner);
        }
        newItem.onEquip(owner);
    }

    public void addItem(InvItem item){
        if (inventory.size() < size) {
            inventory.add(item);
        } else {
            GameController.sc.gameTextAreaNewLine("Inventory Full");
        }
    }

    //TODO: Implement
    public void unequip() {

    }
}
