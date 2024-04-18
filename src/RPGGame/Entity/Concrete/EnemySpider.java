package RPGGame.Entity.Concrete;
import RPGGame.Entity.Abstracts.Player;
import RPGGame.Entity.Abstracts.Enemy;
import static RPGGame.Helper.DamageType.*;

//This should work as a framework to easily add any other enemy types
public class EnemySpider extends Enemy {

    EnemySpider(int lootMoney, Player player){
        super(lootMoney);
        this.player = player;
        this.name = "Small Spider";
    }

    public void onTurn( Player player, int turnNumber ) {
        //Looping cycle of moves for the enemy
        switch (turnNumber % 2) {
            case 0 : player.takeDamage(PHYS, player,1);
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
