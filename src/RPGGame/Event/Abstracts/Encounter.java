package RPGGame.Event.Abstracts;

import RPGGame.Entity.Abstracts.Enemy;
import RPGGame.Entity.Abstracts.Player;

public abstract class Encounter extends Event {
    Enemy enemy;
    Encounter(Enemy enemy){
        this.enemy = enemy;
    }
    @Override
    public boolean run(Player player){

        return false;
    }
}
