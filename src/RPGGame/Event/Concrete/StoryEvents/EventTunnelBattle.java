package RPGGame.Event.Concrete.StoryEvents;    /* Import necessary classes and packages */

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventTunnelBattle extends StoryEvent {        /* Class to handle the event of tunnel battle */ 
    EventTunnelBattle(){            /* Constructor for the event */
        super();
        this.setEventText("""
                As you make your way through the secret tunnel, you see a bright light near the end. But a low growl echoing comes from the shadows. Suddenly, a massive beast emerges, its eyes gleaming with malice.
                The cave beast stands between you and the exit, its massive claws ready to strike. You must defeat the beast to continue your journey.
                """);                 /* Setting the introductory text for the event */
        this.setReencounterText("""
                This is your only chance to leave and survive. What will you do?
                """);
        this.addChoice(new Choice("Fight the cave beast") {        /* Adding a choice where the player can fight the cave beast */
            @Override
            public void execute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.KNIFE)) {                    /* Check before the choice is executed to ensure the player has a knife */
                    scene.gameOutput("You fight off the beast and it slowly crawls away from the damages you caused. You exit the secret tunnel and a snow-laden forest comes your to your path. Your heart races as you see a moose walk by. With its limbs of a spider, all made from gleaming, cold metal ");
                    new EventSnowyRidge().run(player, scene, true);    /* Initiates a new event as the and takes user to next scene. Player heads to snowy ridge. */
                }
            }
        });
        this.addChoice(new Choice("Try to evade the cave beast and find another way around") {       /* Adding a choice where the player can try to evade the cave beast and find another way around */
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You attempt to evade the cave beast and find another way around, but the beast is relentless, blocking every path you try to take.");
                 player.die("The beast claws your body over and over till you're left in your own pool of blood", scene);        /* Player dies and re-enters scene */
            }
        });
    }
}

