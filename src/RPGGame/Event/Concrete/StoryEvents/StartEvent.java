package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.GameController;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;


public class StartEvent extends StoryEvent {
    //this event is the entry point into the story
    public StartEvent(){
        super();
        eventText = "A piercing light breaches you consciousness. You are buried in the snow from the chest down. You look around to notice sun burnt spots in your eyes contrasting with the white foreground.";
        choices.add(new Choice("Dig yourself out") {
            @Override
            public void execute(Player player) {
                System.out.println("Adrenaline takes over. You claw at the snow with aching numb hands. You are free.");
                new StartTransitionEvent().run(player);
            }
        });
        choices.add(new Choice("Close your eyes.") {
            @Override
            public void execute(Player player) {
                System.out.println("Just 5 more minutes...");
                player.die("At least you'll be well preserved.");
            }
        });
    }

}
