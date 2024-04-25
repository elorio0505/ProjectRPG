package RPGGame.Item.Abstracts;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Item.Abstracts.Helper.EquipmentType;

public abstract class EquippableItem extends InvItem {
    EquipmentType type;
    int physDefense;
    int specDefense;
    int physAttack;
    int specAttack;
    int speed;
    int luck;
    public EquippableItem() {
        this.physDefense = physDefense();
        this.specDefense = specDefense();
        this.physAttack = physAttack();
        this.specAttack = specAttack();
        this.speed = speed();
        this.luck = luck();
    }

    //Create equippable item with no stats
    public abstract EquipmentType type();
    public void onUneuip(Player player) {
        player.physAttack -= this.physAttack;
        player.physDefense -= this.physDefense;
        player.specAttack -= this.specAttack;
        player.specDefense -= this.specDefense;
        player.speed -= this.speed;
        player.luck -= this.luck;
    }
    public void onEquip(Player player) {
        player.physAttack += this.physAttack;
        player.physDefense += this.physDefense;
        player.specAttack += this.specAttack;
        player.specDefense += this.specDefense;
        player.speed += this.speed;
        player.luck += this.luck;
    }

    //Required to override these to set equipment stats
    public abstract int physDefense();
    public abstract int specDefense();
    public abstract int physAttack();
    public abstract int specAttack();
    public abstract int speed();
    public abstract int luck();

    public EquipmentType GetType() { return type; }
    public int getPhysDefense() { return physDefense; }
    public int getSpecDefense() {
        return specDefense;
    }
    public int getPhysAttack() {
        return physAttack;
    }
    public int getSpecAttack() {
        return specAttack;
    }
    public int getSpeed() {
        return speed;
    }
    public int getLuck() {
        return luck;
    }
}
