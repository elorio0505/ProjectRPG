package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.StoryEvent;
import RPGGame.Event.Concrete.StoryEvents.TestEvent;

// TODO build a basic loop that allows for testing
public class GameController {
    Player player;
    EventController eventControl;

    public void start(String name) {
        player = new Player(name);
        SceneController.start(player);
        eventControl = new EventController();

        // TEST --------------------------------------------------------------------------------------------------------
        StoryEvent testEvent = new TestEvent();
        testEvent.run(player);
    }
}
