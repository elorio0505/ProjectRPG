package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;


public class StartEvent extends StoryEvent {
    //this event is the entry point into the story
    public StartEvent(){
        super();
        this.setEventText("""
                        Your eyes flutter open, and a piercing white light breaches your eyes and burns your consciousness.
                        As your eyes adjust, you realize you are buried in snow from the chest down, and that you're completely numb.
                        Your vision is spotty, frantically attempting to adjust to the bright light, but as far as you can tell,
                        you are buried in a hole in a snowy wasteland.""");
        this.addChoice(new Choice("Attempt to move your body and dig yourself out.") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Adrenaline takes over. You claw at the snow with aching numb hands. You are free.");
                new EventTreeAndTracks().run(player, scene, true);
            }
        });
        this.addChoice(new Choice("Close your eyes. The numb is bliss.") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Just five more minutes...");
                player.die("At least you'll be well preserved.", scene);
            }
        });
    }

}
