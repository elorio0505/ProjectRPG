package RPGGame.Event.Abstracts;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;

public abstract class Event { // -- erica
    public abstract boolean run(Player player, PrimaryScene scene, boolean firstEncounter);

}
