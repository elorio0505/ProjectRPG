package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;
import RPGGame.Items;
import RPGGame.Player;

public class EventMooseFight extends StoryEvent { // --devin
    EventMooseFight(){
        super();
        this.setEventText("""
                As you venture deeper into the snow-laden forest, a rustling noise from a nearby thicket alerts you to danger. A bizarre creature emerges, unlike anything you've ever seen. It’s a mechanical hybrid, with the body of a moose and the limbs of a spider, all made from gleaming, cold metal. Its eyes, glowing with a fierce red light, fixate on you as it clanks menacingly closer.
                """);

        this.addChoice(new Choice("Use Knife") {
                           @Override
                           public void preExecute(Player player, PrimaryScene scene) {
                               if (!player.hasItem(Items.KNIFE)) {
                                   this.makeUnchoosable();
                               }
                           }

                           @Override
                           public void execute(Player player, PrimaryScene scene) {
                                   scene.gameOutput("The creature barrels toward you. You hold out your knife.");
                                   player.die("You were pummeled", scene);
                           }
                       }
        );
        this.addChoice(new Choice("Run") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You jolt into action, making a sorry attempt at running in the opposite direction.");
                if (player.hasItem(Items.KNIFE)){
                    scene.gameOutput("The creature seems to be spooked by something, perhaps the sunlight glinting off your knife as you ran. It retreats. You are shaken, but continue walking.");
                    new EventSnowyRidge().run(player, scene, true);
                } else {
                    scene.gameOutput("Your feet give out from under you.");
                    player.die("You were pummeled", scene);

                }
            }
        });

        this.addChoice(new Choice("Hide behind a tree") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You jolt into action, rushing behind a nearby spruce to your left. The creature stops on the other side for a moment. It begins circling the tree as you move in succession to avoid it. To your left a massive antler, to the right, the beasts back end. This dance continues until the base of the tree throws you down to the ground...");
                player.die("You were pummeled", scene);
            }
        });

    }
}
