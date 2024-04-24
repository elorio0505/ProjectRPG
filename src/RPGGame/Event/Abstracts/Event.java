package RPGGame.Event.Abstracts;

import RPGGame.Controller.SceneController;
import RPGGame.Entity.Abstracts.Player;

public abstract class Event {
    public abstract boolean run(Player player);

}
