package RPGGame.Entity;

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

    // It's not super elegant, but this will force all children of this class to set the stat values.
    public abstract int maxLifeValue();
    public abstract int physAttackValue();
    public abstract int specAttackValue();
    public abstract int physDefenseValue();
    public abstract int specDefenseValue();
    public abstract int speedValue();
    public abstract int luckValue();
}
