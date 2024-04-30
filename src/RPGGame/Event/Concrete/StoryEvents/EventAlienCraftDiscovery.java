package RPGGame.Event.Concrete.StoryEvents;    /* Import necessary classes and packages */

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventAlienCraftDiscovery extends StoryEvent { /* Class to handle the event of discovering an alien spacecraft --devin */    
    public EventAlienCraftDiscovery() {    /* Constructor for the event */
        super();
        this.setEventText("""        
                As you approach the spacecraft, its smooth, metallic surface glints under the fading sunlight. The craft is larger than it appeared from a distance, and its technology is unlike anything you've ever seen. The entry hatch is slightly ajar, emitting a soft, pulsing light that beckons you closer. You step inside. You notice what appears to be a key hole on the dash.
                """);        /* Setting the introductory text for the event */

        this.addChoice(new Choice("Place Amulet in Keyhole") {    /* Adding a choice where the player can use an amulet with the spacecraft */
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.AMULET)) {                /* Check before the choice is executed to ensure the player has the amulet */
                    this.makeUnchoosable();                          /* Make the choice unselectable if the amulet is missing */
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {        /* Define what happens when this choice is executed */
                scene.gameOutput("You approach the control panel inside the spacecraft and place the amulet in a slot that seems to be made for it. It feels surprisingly natural. The panel lights up, and a screen displays a message, 'Welcome back, Commander.'");
                scene.gameOutput("With a rumble, the spacecraft powers up, and the stars outside begin to move as the craft ascends swiftly into the sky, leaving the planet behind.");
                scene.gameOutput("Congratulations, you've successfully escaped the planet and unlocked the mystery of your past!");
                scene.gameOutput("---===GOOD ENDING===---");                /* Informs user game has ended and had gotten the good ending */
                scene.gameOutput("Enter 1 to play again.");
                while (true) {
                    try {
                        String input = scene.waitForNewInput();            /* Wait for player input */
                        if (input.equals("1")){
                            scene.gameOutputClear();                       /* Clear previous outputs */
                            new EventStart().run(new Player(player.name),scene, true);    /* Restart the game */
                        } else {
                            System.exit(1);                                /* Exit the game if any other input is received */
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);                      /* Handle exceptions during input waiting */
                    }
                }
            }
        });

        this.addChoice(new Choice("Interact with the spacecraft") {        /* Adding a choice to interact with the spacecraft */
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You wander through the corridors of the spacecraft, marveling at its alien technology. Curiosity gets the best of you, and you begin to press various controls in an attempt to operate the ship.");
                scene.gameOutput("Suddenly, the ship's internal defense system activates. A robotic voice demands identification. Unable to provide the correct credentials, you are quickly overwhelmed by security measures.");
                player.die("The ship's defense system determines you as a threat and eliminates you.", scene);
            }
        });

        this.addChoice(new Choice("Head back to camp") {                       /* Adding a choice to leave the spacecraft and head back to camp */
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Unsure of how to operate the alien technology, you decide to exit the spacecraft and return to camp.");    /* Initiates a new event as the and takes user to next scene. Player heads back to camp. */
                new EventSnowyRidge().run(player, scene, false);
            }
        });
    }
}
