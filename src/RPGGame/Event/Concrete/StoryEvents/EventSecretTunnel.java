package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventSecretTunnel extends StoryEvent {
    EventSecretTunnel(){
        super();
        this.setEventText("""
                As you explore the cave, you notice a small opening hidden behind a waterfall. The sound of rushing water fills the air, masking any other sounds that might be lurking in the darkness.
                You cautiously approach the opening and peek inside, revealing a secret tunnel. You also spot a flashlight lying on the ground, its beam flickering weakly.
                """);
        this.setReencounterText("""
                The secret tunnel beckons you, its mysteries waiting to be uncovered.
                """);
        this.addChoice(new Choice("Enter the secret tunnel") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You enter the secret tunnel, the sound of rushing water fading behind you as you venture into the unknown depths of the cave system.");
                // Implement consequences of entering the secret tunnel (e.g., discovering hidden treasures, encountering new enemies)
            }
        });
        this.addChoice(new Choice("Pick up the flashlight and enter the secret tunnel") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You pick up the flashlight and turn it on, its beam cutting through the darkness. With the flashlight in hand, you enter the secret tunnel, ready to uncover its mysteries.");
                player.addItem(Items.FLASHLIGHT);
                // Implement consequences of picking up the flashlight and entering the secret tunnel
            }
        });
        this.addChoice(new Choice("Ignore the secret tunnel and continue exploring the cave") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You decide to continue exploring the main cave, leaving the secret tunnel and the flashlight unexplored for now.");
                // Implement consequences of ignoring the secret tunnel (e.g., missing out on hidden treasures or encounters)
            }
        });
    }
}
