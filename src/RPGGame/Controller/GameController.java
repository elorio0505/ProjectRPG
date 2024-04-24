package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.Event;
import RPGGame.Event.Abstracts.StoryEvent;
import RPGGame.Event.Concrete.StoryEvents.StartEvent;
import RPGGame.Event.Concrete.StoryEvents.TestEvent;

import static RPGGame.Controller.EventController.createEvent;
import static java.lang.System.exit;

// TODO build a basic loop that allows for testing
public class GameController {
    private SceneController sceneController;
    private EventController eventController;
    private Player player;

    private Event currentEvent;
    public GameController() {
        this.sceneController = new SceneController();
        this.eventController = new EventController(sceneController);
        this.player = new Player("PlayerName");
    }

    public void startGame() {
        sceneController.start();
        currentEvent = new StartEvent();
        runGameLoop();
    }

    private void runGameLoop() {
        while (player.isAlive()) {
            currentEvent.run(player);
        }
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
