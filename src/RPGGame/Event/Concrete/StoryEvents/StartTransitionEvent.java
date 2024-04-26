package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.EventController;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class StartTransitionEvent extends StoryEvent {
    //this event gives some backstory, then sets up the player for the events ahead
    StartTransitionEvent(){
        super();
        this.setEventText("You can't feel your legs. You hobble around in a couple small circles to make sure they still work. You grasp your belt buckle for your radio but its not there. Your mind is foggy but you remember you are a soldier, a recollection aided by the uniform you wear. The last thing you recall is falling, falling.. from where? Doesn't matter. You attempt to take stock in your surroundings, though you can't see far as snow fall pummels the earth. You spot a knife handle sticking out of a spruce a few meters from you. You see what appears to be animal tracks nothing like what you've seen before, but they must be fresh considering the snowfall.");
        this.addChoice(new Choice("Grab the knife") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                    if (!player.hasItem(Items.KNIFE)) {
                        scene.gameTextAreaNewLine("You walk over to the spruce. You manage to shimmy the knife out and store it on your belt");
                        player.addItem(Items.KNIFE);
                    } else {
                        scene.gameTextAreaNewLine("You already did this.");
                    }
                };
            }
        );
        this.addChoice(new Choice("Follow the tracks") {
            @Override
            public void execute(Player player,PrimaryScene scene) {
                //EventController.createEncounter();
            }
        });
        this.addChoice(new Choice("Walk in the opposite direction of the tracks.") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                EventController.createEvent();
            }
        });
    }
}
