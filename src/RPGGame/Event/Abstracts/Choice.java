package RPGGame.Event.Abstracts;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;

public abstract class Choice { //-- Erica
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

    public void preExecute(Player player, PrimaryScene scene) {
        // This method is called for each choice before they are given to the player. The purpose of this is to make checks where,
        // in certain situations, able to be disabled if the player meets/fails to meet certain requirements.
    };
    public abstract void execute(Player player, PrimaryScene scene);
}
