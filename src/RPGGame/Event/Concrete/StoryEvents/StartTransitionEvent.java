package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.EventController;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class StartTransitionEvent extends StoryEvent {
    //this event gives some backstory, then sets up the player for the events ahead
    StartTransitionEvent(){
        super();
        eventText = "You can't feel your legs. You hobble around in a couple small circles to make sure they still work. You grasp your belt buckle for your radio but its not there. Your mind is foggy but you remember you are a soldier, a recollection aided by the uniform you wear. The last thing you recall is falling, falling.. from where? Doesn't matter. You attempt to take stock in your surroundings, though you can't see far as snow fall pummels the earth. You spot a knife handle sticking out of a spruce a few meters from you. You see what appears to be animal tracks nothing like what you've seen before, but they must be fresh considering the snowfall.";
        choices.add(new Choice("Grab the knife") {
            @Override
            public void execute(Player player) {
                System.out.println("You walk over to the spruce. You manage to shimmy the knife out.");
                this.makeUnchoosable();
                };
            }
        );
        choices.add(new Choice("Follow the tracks") {
            @Override
            public void execute(Player player) {
                //EventController.createEncounter();
            }
        });
        choices.add(new Choice("Walk in the opposite direction of the tracks.") {
            @Override
            public void execute(Player player) {
                EventController.createEvent(player);
            }
        });
    }
}
