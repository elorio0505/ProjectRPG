package RPGGame.Controller;

import RPGGame.Item.Abstracts.*;
import RPGGame.Item.Concrete.EmptyEquipment;
import java.util.ArrayList;
import static RPGGame.Item.Abstracts.EquipmentType.*;

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

    //Note: Equipped items still use normal inventory space
    public void equip(EquippableItem IncomingItem) {
        switch (IncomingItem.GetType()) {
            case WEAPON:
                weapon = IncomingItem;
                break;
            case HEAD:
                headwear = IncomingItem;
                break;
            case BODY:
                chestwear = IncomingItem;
                break;
            case LEGS:
                legwear = IncomingItem;
                break;
            case RING:
                ring = IncomingItem;
                break;
        }
    }

    //unequip method //Fills equipment slot with empty
    /*TODO: Current implementation performs unequip when any item of same type is passed,
        Either use a generic object of same type as the parameter to make it a generic unequip function (preferred),
        or needs to check if the item matches the equipped item
    */
    public void unequip(EquippableItem IncomingItem) {
        switch (IncomingItem.GetType()) {
            case WEAPON:
                weapon = empty;
                break;
            case HEAD:
                headwear = empty;
                break;
            case BODY:
                chestwear = empty;
                break;
            case LEGS:
                legwear = empty;
                break;
            case RING:
                ring = empty;
                break;
        }
    }
}
