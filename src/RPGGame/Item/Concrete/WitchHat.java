package RPGGame.Item.Concrete;

import static RPGGame.Item.Abstracts.Helper.EquipmentType.*;
import RPGGame.Item.Abstracts.EquippableItem;
import RPGGame.Item.Abstracts.Helper.EquipmentType;

//Example Equipment
public class WitchHat extends EquippableItem {
    @Override
    public EquipmentType type() { return HEAD; }

    //Create equippable item with no stats
    @Override
    public int value() { return 20; }
    @Override
    public String itemName() { return "Witch Hat"; }
    @Override
    public int physDefense() { return 1; }
    @Override
    public int specDefense() { return 1; }
    @Override
    public int physAttack() { return 0; }
    @Override
    public int specAttack() { return 1; }
    @Override
    public int speed() { return 0; }
    @Override
    public int luck() {return 0; }
}
