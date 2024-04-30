package RPGGame.Event.Abstracts;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;

public abstract class Choice { //-- Erica
    String text;     // Text description of the choice
    private boolean choosable;    // Private boolean to determine if the choice is currently selectable

    public Choice(String text) {    // Set the text description of the choice
        this.text = text;
        choosable = true;
    }

    public String getText(){        // Returns the text description of this choice
        return text;
    }

    public void makeUnchoosable(){    //Makes this choice as unselectable
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
