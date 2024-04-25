package RPGGame.Event.Abstracts;

import RPGGame.Controller.GameController;
import RPGGame.Player;

import java.util.ArrayList;

public abstract class StoryEvent extends Event {
    public String eventText;
    //Array of choices
    public ArrayList<Choice> choices;

    public StoryEvent() {
        choices = new ArrayList<Choice>();
    }

    @Override
    public boolean run(Player player) {
        System.out.println(eventText);
        int i = 0;
        for (Choice c : choices) {
            System.out.println("[" + ++i + "]  " + c.text);
        }
        int input = Integer.parseInt(GameController.sc.nextLine());
        choices.get(input - 1).execute(player);
        return true;
    }
}
