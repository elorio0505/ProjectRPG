package RPGGame.Entity.Abstracts;

import RPGGame.Controller.InventoryController;
import RPGGame.Controller.SceneController;
import RPGGame.Helper.DamageType;

import static java.lang.System.exit;

// TODO complete implementation
public class Player extends Entity {
    final int DEFAULT_INVENTORY_SIZE = 8;
    public int maxLifeMod, physAttackMod, specAttackMod, physDefenseMod, specDefenseMod, speedMod, luckMod, gold = 0;

    InventoryController inv;
    public String name;

    public Player(String name) {
        this.name = name;
        inv = new InventoryController(DEFAULT_INVENTORY_SIZE);
    }

    @Override
    public void DamageEvent(DamageType dmgType, Entity player, int dmg) {
        switch (dmgType) {
            case PHYS:
                currentLife -= (dmg - (physDefense + physDefenseMod));
                triggerArmorEffects(dmgType, player, dmg);
                break;
            case SPEC:
                currentLife -= (dmg - (specDefense + specDefenseMod));
                triggerArmorEffects(dmgType, player, dmg);
                break;
            case LOSS:
                currentLife -= (dmg);
                triggerArmorEffects(dmgType, player, dmg);
                break;
            case HEAL:
                currentLife += dmg;
                break;
        }
        if (currentLife <= 0) {
            currentLife = 0;
            die(this);
        }
        if (currentLife > maxLife + maxLifeMod) {
            currentLife = maxLife + maxLifeMod;
        }
    }

    public void triggerArmorEffects(DamageType dmgType, Entity player, int dmg) {
        //TODO Equipment Damage Mitigation
        //Total (aka Effective) stats calculated every time, Maybe it could be calculated and saved from equip/unequip
        switch (dmgType) {
            case PHYS:
                int EPhysDefense = player.physDefense;
                break;
            case SPEC:
                currentLife -= (dmg - (specDefense + specDefenseMod));
                triggerArmorEffects(dmgType, player, dmg);
                break;
            case LOSS:
                currentLife -= (dmg);
                triggerArmorEffects(dmgType, player, dmg);
                break;
            case HEAL:
                currentLife += dmg;
                break;
        }
    }

    @Override
    public void die(Player player) {
        super.die(player);
        SceneController.gameTextAreaClear();
        SceneController.gameTextAreaNewLine("YOU DIED!");
        SceneController.gameRunning = false;
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
