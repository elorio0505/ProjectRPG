package RPGGame.Controller;

import RPGGame.Entity.Player;

// TODO complete implementation
public class GameController {
    Player player;
    SceneController sceneControl;
    EventController eventControl;

    public void start(String name) {
        player = new Player(name);
        eventControl = new EventController();
        sceneControl = new SceneController(player);
    }
}
