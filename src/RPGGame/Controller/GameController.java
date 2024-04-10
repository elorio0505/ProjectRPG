package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;

// TODO build a basic loop that allows for testing
public class GameController {
    Player player;
    SceneController sceneControl;
    EventController eventControl;

    public void start(String name) {
        player = new Player(name);
        sceneControl = new SceneController(player);
        // TODO: See if it's feasible to make the SceneController static, that'll be better so that any class can fuck with it
        eventControl = new EventController();
    }
}
