package RPGGame.Event.Abstracts;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;

public abstract class Choice {
    String text;
    private boolean choosable;

    public Choice(String text) {
        this.text = text;
        choosable = true;
    }

    public String getText(){
        return text;
    }

    public void makeUnchoosable(){
        choosable = false;
    }

    public boolean isChoosable(){
        return choosable;
    }

    public abstract void execute(Player player, PrimaryScene scene);
}
