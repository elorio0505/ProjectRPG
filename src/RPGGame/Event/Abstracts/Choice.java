package RPGGame.Event.Abstracts;

import RPGGame.Entity.Abstracts.Player;

import java.util.ArrayList;

public abstract class Choice {
    String text;
    ArrayList<Choice> choices;

    public Choice(String text) {
        this.text = text;
    }

    public abstract void execute(Player player);
}
