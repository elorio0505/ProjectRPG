package RPGGame.Event.Concrete.StoryEvents;
import RPGGame.Items;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventCaveEntrance extends StoryEvent {
    EventCaveEntrance() {
        super();
        this.setEventText("""
                Success!! The river slowed down and you were able to cross. he air around it is cool and damp, and you can hear the echo of water dripping from within.
                There's an eerie feeling about the place, but something draws you toward it.
                """);
        this.setReencounterText("""
                The cave entrance looms before you, its darkness inviting yet foreboding. The sound of mutant bats echoes from within and they start to attack you!
                """);
        this.addChoice(new Choice("Enter the cave and fight the mutant bats") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.KNIFE)) {
                    scene.gameOutput("You are surrounded by the creatures, and a chaotic battle ensues.");
                    // Implement consequences of entering the cave and fighting the bats with the knife.
                } else {
                    scene.gameOutput("You step into the cave, the sound of bats growing louder as you venture deeper into the darkness. Without a weapon, you are quickly overwhelmed by the swarm of bats.");
                    // Implement consequences of entering the cave without the knife (e.g., losing health or fleeing).
                }
            }
        });
    }
}

