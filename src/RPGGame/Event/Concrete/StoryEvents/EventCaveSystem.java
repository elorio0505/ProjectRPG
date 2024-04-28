package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventLostCave extends StoryEvent {
    EventCaveSystem(){
        super();
        this.setEventText("""
                You slip on loose gravel and tumble into a dark cavern. After regaining your bearings, you realize you are in a vast cave system, with no immediate way out.
                The cave is eerily quiet, and your only source of light is a dimly glowing moss on the walls. You must find a way out before it's too late.
                """);
        this.setReencounterText("""
                The cave's twists and turns seem endless. But there's two distinct paths with dimly glowing moss. What will you do?
                """);
        this.addChoice(new Choice("Search the left path of the cave") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You begin to explore the left path of the cave, hoping to find an exit. The moss-covered walls and eerie silence make your journey unsettling.");
                new EventCaveSystemLeft().run(player, scene, true);
            }
        });

        this.addChoice(new Choice("Search the right path of the cave") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You begin to explore the right path cave, hoping to find an exit. The moss-covered walls and eerie silence make your journey unsettling.");
                new EventCaveSystemRight().run(player, scene, true);
            }
        });
      
        this.addChoice(new Choice("Scream for help") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You scream for help, hoping someone will hear you. The sound echoes through the cave, but it awakens a cave beast. You pull out your knife and try to fight, but it's too dark to see without a flashlight and the beast mauls you to pieces.");
                player.die("You've been mauled by a cave beast", scene);
            }
        });
    }
}

