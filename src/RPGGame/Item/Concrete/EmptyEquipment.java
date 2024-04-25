package RPGGame.Item.Concrete;

import RPGGame.Item.Abstracts.EquippableItem;
import RPGGame.Item.Abstracts.Helper.EquipmentType;

//"Empty" with 0 stats replaces equipment when gear is unequipped
public class EmptyEquipment extends EquippableItem {
    //Create equippable item with no stats
    @Override
    public EquipmentType type() { return null; }
    @Override
    public int value() { return 0; }
    @Override
    public String itemName() { return null; }
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
