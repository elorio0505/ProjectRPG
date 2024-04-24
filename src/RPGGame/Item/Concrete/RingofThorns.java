package RPGGame.Item.Concrete;

import static RPGGame.Item.Abstracts.Helper.EquipmentType.*;
import RPGGame.Item.Abstracts.EquippableItem;
import RPGGame.Item.Abstracts.Helper.EquipmentType;

//Example Equipment
public class RingofThorns extends EquippableItem {
    @Override
    public EquipmentType type() { return RING; }

    //Create equippable item with no stats
    @Override
    public int value() { return 20; }
    @Override
    public String itemName() { return "Ring of Thorns"; }
    @Override
    public int physDefense() { return 0; }
    @Override
    public int specDefense() { return 0; }
    @Override
    public int physAttack() { return 0; }
    @Override
    public int specAttack() { return 0; }
    @Override
    public int speed() { return 0; }
    @Override
    public int luck() {return 0; }
}
