package RPGGame.Controller;

import RPGGame.Player;                                /* Import necessary classes for handling the player and starting the game event */
import RPGGame.Event.Concrete.StoryEvents.EventStart;

/* This class is responsible for managing the game, including initializing and starting the game */
public class GameController { //-- erica
    static boolean gameRunning;    // Static variable to keep track of whether the game is currently running
    private Player player;         // Private variable for Player to maintain the player's state in the game
    private PrimaryScene scene;    // Private variable for PrimaryScene to manage the main scene of the game.

    public GameController() {
        this.player = new Player("PlayerName");    // Initialize the player object with a name to be used throughout the game
    }

    public void startGame() {                    //Starts the game by setting up necessary components and running the initial game event
        System.out.println("Starting Game...");    // Output to indicate that the game is starting
        scene = new PrimaryScene();                // Create a new scene object which will be the main environment for the game
        scene.start();                             // Start the primary scene 
        gameRunning = true;                        // Set the gameRunning flag to true so the game is now active
        new EventStart().run(player, scene, true);    // Run the first event of the game, using the player and scene objects.
    }
}
