package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;

// TODO build a basic loop that allows for testing
public class GameController {
    Player player;
    EventController eventControl;

    public void start(String name) {
        player = new Player(name);
        SceneController.start(player);
        eventControl = new EventController();
    }
}
