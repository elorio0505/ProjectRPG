package RPGGame.Event.Abstracts;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;

public abstract class Event {
    public abstract boolean run(Player player, PrimaryScene scene, boolean firstEncounter);

}
