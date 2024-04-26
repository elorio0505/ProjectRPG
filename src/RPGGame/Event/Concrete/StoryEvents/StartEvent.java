package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.GameController;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;


public class StartEvent extends StoryEvent {
    //this event is the entry point into the story
    public StartEvent(){
        super();
        this.setEventText("A piercing light breaches you consciousness. You are buried in the snow from the chest down. You look around to notice sun burnt spots in your eyes contrasting with the white foreground.");
        this.addChoice(new Choice("Dig yourself out") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameTextAreaNewLine("Adrenaline takes over. You claw at the snow with aching numb hands. You are free.");
                new StartTransitionEvent().run(player, scene);
            }
        });
        this.addChoice(new Choice("Close your eyes.") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameTextAreaNewLine("Just 5 more minutes...");
                player.die("At least you'll be well preserved.", scene);
            }
        });
    }

}
