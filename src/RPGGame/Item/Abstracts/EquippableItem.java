package RPGGame.Item.Abstracts;

import RPGGame.Entity.Abstracts.Entity;
import RPGGame.Helper.DamageType;

public abstract class EquippableItem extends InvItem {
    int physDefense;
    int specDefense;
    int physAttack;
    int specAttack;
    public EquippableItem() {
        this.physDefense = physDefense();
        this.specDefense = specDefense();
        this.physAttack = physAttack();
        this.specAttack = specAttack();
    }

    //Required to override these to set equipment stats
    public abstract int physDefense();
    public abstract int specDefense();
    public abstract int physAttack();
    public abstract int specAttack();
}
