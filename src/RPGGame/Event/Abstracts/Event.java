package RPGGame.Event.Abstracts;

import RPGGame.Entity.Abstracts.Player;

public abstract class Event {
    public abstract boolean run(Player player);
}
