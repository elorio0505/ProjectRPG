package RPGGame.Controller;

import RPGGame.Item.Abstracts.*;
import RPGGame.Item.Concrete.EmptyEquipment;
import java.util.ArrayList;

// TODO complete implementation
public class InventoryController {
    ArrayList<InvItem> inventory;
    public EquippableItem weapon;
    public EquippableItem headwear;
    public EquippableItem chestwear;
    public EquippableItem legwear;
    public EquippableItem ring;
    int size;
    EmptyEquipment empty;

    public InventoryController(int size) {
        inventory = new ArrayList<InvItem>();
        this.size = size;
        EmptyEquipment empty = new EmptyEquipment();
    }

    //Overloaded equip method
    //Note: Equipped items still use normal inventory space
    public void equip(WeaponItem IncomingItem) { weapon = IncomingItem; }
    public void equip(HeadItem IncomingItem) { headwear = IncomingItem; }
    public void equip(ChestItem IncomingItem) { chestwear = IncomingItem; }
    public void equip(LegItem IncomingItem) { legwear = IncomingItem; }
    public void equip(RingItem IncomingItem) { ring = IncomingItem; }

    //Overloaded unequip method //Fills equipment slot with empty
    /*TODO: Current implementation performs unequip when any item of same type is passed,
        Either use a generic object of same type as the parameter to make it a generic unequip function (preferred),
        or needs to check if the item matches the equipped item
    */
    public void unequip(WeaponItem IncomingItem) { weapon = empty; }
    public void unequip(HeadItem IncomingItem) { headwear = empty; }
    public void unequip(ChestItem IncomingItem) { chestwear = empty; }
    public void unequip(LegItem IncomingItem) { legwear = empty; }
    public void unequip(RingItem IncomingItem) { ring = empty; }
}
