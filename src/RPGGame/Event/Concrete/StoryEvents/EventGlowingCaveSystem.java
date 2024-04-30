package RPGGame.Event.Concrete.StoryEvents;     /* Import necessary classes and packages */
import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventGlowingCaveSystem extends StoryEvent {    /* Class to handle the event of tunnel battle */ 
  EventGlowingCaveSystem() {        /* Constructor for the event */
    super();
    this.setEventText(""" 
            As you are walking down the glowing moss path, a rock stops you in your tracks.
            """);
    this.setReencounterText("""     /* Setting the introductory text for the event */
            You believe that if you move this rock, you can continue your way onto the path.
            """);
           this.addChoice(new Choice("Move the rock")    /* Adding a choice where the player can move the rock */
            @Override
            public void execute(Player player, PrimaryScene scene) {    /* Define what happens when this choice is executed */
                scene.gameOutput("You were sucessful moving the big rock out of the way and continue on'");
                scene.gameOutput("The path is a dead end and decide to turn back. However, the rock you just moved kept ahold of the cave system entirely. And all the rocks fall to the ground covering up the exit. You try to move the rocks but they are too compact together to move");
                scene.gameOutput("Unfortunately your stuck in this cave forever!");
                scene.gameOutput("---===BAD ENDING===---");            /* Informs user game has ended and had gotten the bad ending */
                scene.gameOutput("Enter 1 to play again.");
                while (true) {
                    try {
                        String input = scene.waitForNewInput();     /* Wait for player input */
                        if (input.equals("1")){
                            scene.gameOutputClear();                /* Clear previous outputs */
                            new EventStart().run(new Player(player.name),scene, true);    /* Restart the game */
                        } else {
                            System.exit(1);                        /* Exit the game if any other input is received */
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);              /* Handle exceptions during input waiting */
                    }
                }
            }
        });
    
    this.addChoice(new Choice("Go back to the cave entrance") {      /* Adding a choice to go back to cave entrance */
      @Override 
      public void execute(Player player, PrimaryScene scene) {
        scene.gameOutput("You decide to go back since you cannot move the rock.");
        new EventCavEntrance().run(player, scene, true);      /* Adding a choice to go back to the cave entrance */
      }
    });
  }
}
