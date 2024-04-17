package RPGGame.Entity.Abstracts.EnemyTypes;
import RPGGame.Entity.Abstracts.Player;
import RPGGame.Entity.Abstracts.Enemy;
import static RPGGame.Helper.DamageType.*;

//This should work as a framework to easily add any other enemy types

//TODO: I don't think enemies really need the maxLifeMod and similar attributes, maybe those should just be in the Player class instead?
public class EnemySpider extends Enemy {

    EnemySpider(int lootMoney){
        super(lootMoney);
    }

    public void onTurn( Player player, int turnNumber ) {
        //Looping cycle of moves for the enemy
        switch (turnNumber % 2) {
            case 0 : player.takeDamage(PHYS, player,1);     //TODO: I'm not sure if there is a method for dealing damage so I just used ints
                break;
            case 1 : //skip turn
                break;
        }
    }

    @Override
    public int maxLifeValue() {return 3;}

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
