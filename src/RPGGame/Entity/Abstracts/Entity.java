package RPGGame.Entity.Abstracts;

import RPGGame.Helper.DamageType;

// TODO complete implementation
public abstract class Entity {
    // statistics
    public int maxLife, currentLife, physAttack, specAttack, physDefense, specDefense, speed, luck;
    protected Player player;


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

    public void DamageEvent(DamageType dmgType, Entity dmgOwner, int dmg) {
        switch (dmgType) {
            case PHYS, LOSS, SPEC:
                currentLife -= dmg;
                break;
            case HEAL:
                currentLife += dmg;
                break;
        }
        if (currentLife <= 0) {
            currentLife = 0;
            die(player);
        }
        if (currentLife > maxLife) {
            currentLife = maxLife;
        }
    }
    public boolean isAlive(){
        if (currentLife > 0){
            return true;
        }
        return false;
    }
    public void die(Player player) { // TODO: I would prefer to be able to reset the game to it's initial state if you were to die, rather than force-closing the program. Sentinel?

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
