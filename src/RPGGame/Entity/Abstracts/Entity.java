package RPGGame.Entity.Abstracts;

import RPGGame.Helper.DamageType;

// TODO complete implementation
public abstract class Entity {
    // statistics
    int maxLife, currentLife, physAttack, specAttack, physDefense, specDefense, speed, luck;
    int maxLifeMod, physAttackMod, specAttackMod, physDefenseMod, specDefenseMod, speedMod, luckMod = 0;

    public Entity() {
        maxLife = maxLifeValue();
        currentLife = maxLife;
        physAttack = physAttackValue();
        specAttack = specAttackValue();
        physDefense = physDefenseValue();
        specDefense = specDefenseValue();
        speed = speedValue();
        luck = luckValue();
    }

    public void takeDamage(DamageType dmgType, Entity dmgOwner, int dmg) {
        if (dmgType == DamageType.PHYS) {
            currentLife -= (dmg - (physDefense + physDefenseMod));
        } else if (dmgType == DamageType.SPEC) {
            currentLife -= (dmg - (specDefense + specDefenseMod));
        } else if (dmgType == DamageType.LOSS) {
            currentLife -= (dmg);
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

    public void die() {
    }

    // It's not super elegant, but this will force all children of this class to set the stat values.
    public abstract int maxLifeValue();
    public abstract int physAttackValue();
    public abstract int specAttackValue();
    public abstract int physDefenseValue();
    public abstract int specDefenseValue();
    public abstract int speedValue();
    public abstract int luckValue();
}
