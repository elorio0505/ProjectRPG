package RPGGame.Controller;

import RPGGame.Player;
import RPGGame.Event.Abstracts.Event;
import RPGGame.Event.Concrete.StoryEvents.StartEvent;

import javax.swing.*;
import java.util.Scanner;

// TODO build a basic loop that allows for testing
public class GameController {
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
        new StartEvent().run(player, scene, true);
    }
}
