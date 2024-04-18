package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.SceneController;
import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class TestEvent extends StoryEvent {

    public TestEvent() {
        super();
        eventText = "This is a test event.";
        choices.add(new Choice("This is a good choice :)") {
            @Override
            public void execute(Player player) {
                SceneController.gameTextAreaNewLine("You made the right choice, gaining 1 Luck in the process!!! yippee!!");
            }
        });
        choices.add(new Choice("This is a bad choice :(") {
            @Override
            public void execute(Player player) {
                SceneController.gameTextAreaNewLine("You fucking imbecile, you chose POORLY. now DIE.");
                player.die(player);
            }
        });
    }
}
