package RPGGame.Entity.Abstracts;

import RPGGame.Controller.InventoryController;
import RPGGame.Helper.DamageType;

// TODO complete implementation
public class Player extends Entity {
    final int DEFAULT_INVENTORY_SIZE = 8;

    InventoryController inv;
    public String name;

    public Player(String name) {
        this.name = name;
        inv = new InventoryController(DEFAULT_INVENTORY_SIZE);
    }

    @Override
    public void takeDamage(DamageType dmgType, Entity dmgOwner, int dmg) {
        if (dmgType == DamageType.PHYS) {
            currentLife -= (dmg - (physDefense + physDefenseMod));
            triggerArmorEffects(dmgType, dmgOwner, dmg);
        } else if (dmgType == DamageType.SPEC) {
            currentLife -= (dmg - (specDefense + specDefenseMod));
            triggerArmorEffects(dmgType, dmgOwner, dmg);
        } else if (dmgType == DamageType.LOSS) {
            currentLife -= (dmg);
            triggerArmorEffects(dmgType, dmgOwner, dmg);
        } else if (dmgType == DamageType.HEAL) {
            currentLife += dmg;
        }
        if (currentLife <= 0) {
            currentLife = 0;
            die();
        }
        if (currentLife > maxLife + maxLifeMod) {
            currentLife = maxLife + maxLifeMod;
        }
    }

    public void triggerArmorEffects(DamageType dmgType, Entity dmgOwner, int dmg) {
        inv.headwear.onAttacked(dmgType, dmgOwner, dmg);
        inv.chestwear.onAttacked(dmgType, dmgOwner, dmg);
        inv.legwear.onAttacked(dmgType, dmgOwner, dmg);
        inv.ring.onAttacked(dmgType, dmgOwner, dmg);
    }

    // Stat Definitions
    @Override
    public int maxLifeValue() {return 10;}

    @Override
    public int physAttackValue() {return 1;}

    @Override
    public int specAttackValue() {return 1;}

    @Override
    public int physDefenseValue() {return 1;}

    @Override
    public int specDefenseValue() {return 1;}

    @Override
    public int speedValue() {return 1;}

    @Override
    public int luckValue() {return 1;}

}