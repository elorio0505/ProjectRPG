package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.StoryEvent;
import RPGGame.Event.Concrete.StoryEvents.TestEvent;

import static java.lang.System.exit;

// TODO build a basic loop that allows for testing
public class GameController {
    Player player;
    EventController eventControl;

    public void start(String name) {
        player = new Player(name);
        SceneController scController = new SceneController();
        scController.start();
        eventControl = new EventController();

        // TEST --------------------------------------------------------------------------------------------------------
    }
}
