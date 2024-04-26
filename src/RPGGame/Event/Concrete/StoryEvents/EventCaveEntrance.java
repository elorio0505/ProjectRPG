package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventCaveEntrance extends StoryEvent {
    EventCaveEntrance(){
        super();
        this.setEventText("""
                Success!! The river slowed down  you come across a dark cave entrance. The air around it is cool and damp, and you can hear the echo of water dripping from within.
                There's an eerie feeling about the place, but something draws you toward it.
                """);
        this.setReencounterText("""
                The cave entrance looms before you, its darkness inviting yet foreboding.
                """);
        this.addChoice(new Choice("Enter the cave") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You step into the cave, and the darkness envelops you. The only sound is your echoing footsteps as you venture deeper into the unknown.");
                // Implement consequences of entering the cave, such as encountering monsters or finding valuable treasures.
            }
        });
