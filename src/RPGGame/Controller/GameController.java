package RPGGame.Controller;

import RPGGame.Player;
import RPGGame.Event.Concrete.StoryEvents.EventStart;


public class GameController { //-- erica
    static boolean gameRunning;
    private Player player;
    private PrimaryScene scene;

    public GameController() {
        this.player = new Player("PlayerName");
    }

    public void startGame() {
        System.out.println("Starting Game...");
        scene = new PrimaryScene();
        scene.start();
        gameRunning = true;
        new EventStart().run(player, scene, true);
    }
}
