package RPGGame.Item.Abstracts;

import RPGGame.Entity.Abstracts.Entity;

public abstract class WeaponItem extends EquippableItem {
    int dmg;
    protected WeaponItem(int dmg){
        this.dmg = dmg;
    }

    void attack(Entity entity){

    }
}
