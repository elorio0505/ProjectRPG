package RPGGame.Item.Abstracts;

import RPGGame.Entity.Abstracts.Entity;
import RPGGame.Helper.DamageType;

public abstract class EquipabbleItem extends InvItem {
    boolean isEquipped = false;

    // When the item is equipped, this is called.
    public void onEquip() {
        isEquipped = true;
    };

    // When the item is unequipped, this is called.
    public void onUnequip() {
        isEquipped = false;
    };

    // When the wearer of this item is attacked, this is called.
    public abstract void onAttacked(DamageType dmgType, Entity dmgOwner, int dmg);
    public abstract void onAttacked();
}
