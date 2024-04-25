package RPGGame.Controller;

import RPGGame.Player;
import RPGGame.Event.Abstracts.Event;
import RPGGame.Event.Concrete.StoryEvents.StartEvent;

import java.util.Scanner;

// TODO build a basic loop that allows for testing
public class GameController {
    private EventController eventController;
    public static Scanner sc = new Scanner(System.in);
    static boolean gameRunning;
    private Player player;

    private Event currentEvent;
    public GameController() {
        //sc = new SceneController();
        this.eventController = new EventController();
        this.player = new Player("PlayerName");
    }

    public void startGame() {
        System.out.println("Starting Game...");
        gameRunning = true;
        new StartEvent().run(player);
    }

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
    }
}
