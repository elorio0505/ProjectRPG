package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventAlienCraftDiscovery extends StoryEvent { // --devin
    public EventAlienCraftDiscovery() {
        super();
        this.setEventText("""
                As you approach the spacecraft, its smooth, metallic surface glints under the fading sunlight. The craft is larger than it appeared from a distance, and its technology is unlike anything you've ever seen. The entry hatch is slightly ajar, emitting a soft, pulsing light that beckons you closer. You step inside. You notice what appears to be a key hole on the dash.
                """);

        this.addChoice(new Choice("Place Amulet in Keyhole") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.AMULET)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You approach the control panel inside the spacecraft and place the amulet in a slot that seems to be made for it. It feels surprisingly natural. The panel lights up, and a screen displays a message, 'Welcome back, Commander.'");
                scene.gameOutput("With a rumble, the spacecraft powers up, and the stars outside begin to move as the craft ascends swiftly into the sky, leaving the planet behind.");
                scene.gameOutput("Congratulations, you've successfully escaped the planet and unlocked the mystery of your past!");
                scene.gameOutput("---===GOOD ENDING===---");
                scene.gameOutput("Enter 1 to play again.");
                while (true) {
                    try {
                        String input = scene.waitForNewInput();
                        if (input.equals("1")){
                            scene.gameOutputClear();
                            new EventStart().run(new Player(player.name),scene, true);
                        } else {
                            System.exit(1);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        this.addChoice(new Choice("Interact with the spacecraft") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You wander through the corridors of the spacecraft, marveling at its alien technology. Curiosity gets the best of you, and you begin to press various controls in an attempt to operate the ship.");
                scene.gameOutput("Suddenly, the ship's internal defense system activates. A robotic voice demands identification. Unable to provide the correct credentials, you are quickly overwhelmed by security measures.");
                player.die("The ship's defense system determines you as a threat and eliminates you.", scene);
            }
        });

        this.addChoice(new Choice("Head back to camp") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Unsure of how to operate the alien technology, you decide to exit the spacecraft and return to camp.");
                new EventSnowyRidge().run(player, scene, false);
            }
        });
    }
}