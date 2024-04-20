package RPGGame.Item.Concrete;

import RPGGame.Item.Abstracts.EquippableItem;

//Example Equipment
public class IronChestplate extends EquippableItem {
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
}
