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
                Success!! The river slowed down and you were able to cross. The air around it is cool and damp, and you can hear the echo of water dripping from within.
                There's an eerie feeling about the place, but something draws you toward it.
                """);
        this.setReencounterText("""
                The cave entrance looms before you, its darkness inviting yet foreboding. The sound of mutant bats echoes from within and they start to attack you!
                """);
        this.addChoice(new Choice("Go back to your camp") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You run back to your camp you made by the river, however the mutant bats follow you and swarm you.");
                player.die("Swarm of mutant bats ate you alive", scene);
            }
        });
        this.addChoice(new Choice("Enter the cave and fight the mutant bats") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.KNIFE)) {
                    scene.gameOutput("You are surrounded by the creatures, and a chaotic battle ensues. After a long hard fought, you killed all the mutant bats in the cave and continue on your journey");
                     new EventSecretTunnel().run(player, scene, true);
                } else {
                    scene.gameOutput("Without a weapon, you are quickly overwhelmed by the swarm of bats.");
                    player.die("Swarm of mutant bats ate you alive", scene);
                }
            }
        });
    }
}

