package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventCaveBeastBattle extends StoryEvent {
    EventCaveBeastBattle(){
        super();
        this.setEventText("""
                As you make your way through the secret tunnel, you hear a low growl echoing from the shadows. Suddenly, a massive beast emerges, its eyes gleaming with malice.
                The cave beast stands between you and the exit, its massive claws ready to strike. You must defeat the beast to continue your journey.
                """);
        this.setReencounterText("""
                The memory of your battle with the cave beast lingers, a reminder of the dangers that lurk in the depths.
                """);
        this.addChoice(new Choice("Fight the cave beast") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You steel yourself for battle and confront the cave beast head-on. The beast lunges at you with frightening speed, its claws slashing through the air.");
                // Implement consequences of fighting the cave beast (e.g., winning the battle, losing health)
            }
        });
        this.addChoice(new Choice("Try to evade the cave beast and find another way around") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You attempt to evade the cave beast and find another way around, but the beast is relentless, blocking every path you try to take.");
                // Implement consequences of trying to evade the cave beast (e.g., finding a hidden path, losing stamina)
            }
        });
    }
}

