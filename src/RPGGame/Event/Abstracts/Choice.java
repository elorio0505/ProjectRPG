package RPGGame.Event.Abstracts;

import RPGGame.Player;

public abstract class Choice {
    String text;
    private boolean choosable;

    public Choice(String text) {
        this.text = text;
        choosable = true;
    }

    public void makeUnchoosable(){
        choosable = false;
    }

    public boolean isChoosable(){
        return choosable;
    }

    public abstract void execute(Player player);
}
