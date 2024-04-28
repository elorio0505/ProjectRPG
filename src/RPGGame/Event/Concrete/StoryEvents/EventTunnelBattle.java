package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventTunnelBattle extends StoryEvent {
    EventCaveBeastBattle(){
        super();
        this.setEventText("""
                As you make your way through the secret tunnel, you see a bright light near the end. But a low growl echoing comes from the shadows. Suddenly, a massive beast emerges, its eyes gleaming with malice.
                The cave beast stands between you and the exit, its massive claws ready to strike. You must defeat the beast to continue your journey.
                """);
        this.setReencounterText("""
                This is your only chance to leave and survive. What will you do?
                """);
        this.addChoice(new Choice("Fight the cave beast") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                 if (player.hasItem(Items.KNIFE)){
                    scene.gameOutput("You fight off the beast and it slowly crawls away from the damages you caused. You exit the secret tunnel and a snow-laden forest comes your to your path. Your heart races as you see a moose walk by. With its limbs of a spider, all made from gleaming, cold metal ");
                    new EventSnowyRidge().run(player, scene, true);
            }
        });Wi
        this.addChoice(new Choice("Try to evade the cave beast and find another way around") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You attempt to evade the cave beast and find another way around, but the beast is relentless, blocking every path you try to take.");
                 player.die("The beast claws your body over and over till you're left in your own pool of blood", scene);
            }
        });
    }
}

