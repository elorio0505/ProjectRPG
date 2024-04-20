package RPGGame.Item.Concrete;

import RPGGame.Item.Abstracts.ChestItem;
import RPGGame.Item.Abstracts.EquipmentType;
import RPGGame.Item.Abstracts.EquippableItem;


//Example Equipment
public class IronChestplate extends EquippableItem {
    static EquipmentType type = EquipmentType.BODY;

    public EquipmentType GetType() { return type; }

    //Create equippable item with no stats
    @Override
    public int value() { return 20; }
    @Override
    public String itemName() { return "Iron Chestplate"; }
    @Override
    public int physDefense() { return 4; }
    @Override
    public int specDefense() { return 1; }
    @Override
    public int physAttack() { return 0; }
    @Override
    public int specAttack() { return 0; }
    @Override
    public int speed() { return 0; }
    @Override
    public int luck() {return 0; }
}
