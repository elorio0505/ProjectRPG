package RPGGame.Event.Abstracts;

import RPGGame.Controller.OldSceneController;
import RPGGame.Controller.SceneController;
import RPGGame.Entity.Abstracts.Player;

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
        SceneController.gameTextAreaNewLine(eventText);
        int i = 0;
        for (Choice c : choices) {
            OldSceneController.gameTextAreaNewLine("[" + ++i + "]  " + c.text);
        }
        String stale = OldSceneController.lastInput;
        String nextInput = OldSceneController.lastInput;
        int input = -1;
        while (stale.equals(nextInput)) {
            nextInput = OldSceneController.lastInput;
            input = -1;
            try {
                input = Integer.parseInt(nextInput);
            } catch (NumberFormatException e) {
                // continue polling
            }
            if (input < 1 || input > i) {
                stale = nextInput;
            }
        }
        choices.get(input - 1).execute(player);
        return true;
    }
}
