package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventTreeAndTracks extends StoryEvent {
    EventTreeAndTracks(){
        super();
        this.setEventText("""
                You still can't feel your legs. You hobble around to make sure they still work -- thankfully, they do.
                You grasp your belt for your radio but its not there. Your mind is foggy but you remember that you are a soldier,
                though from the landscape, you know that whatever forces you fought for and against are long gone. The last thing you recall is a pale-blue flash, then darkness.
                Doesn't matter anymore. You attempt to take stock of your surroundings, though the veil-like snowfall renders the task borderline pointless.
                However, you spot a combat knife handle sticking out of a desiccated spruce tree a few feet from you.
                On the other hand, you also spot huge prints in the ground, unlike any animal you have knowledge of.
                """);
        this.setReencounterText("""
                Armed qith the knife, maybe you'll have a chance against whatever abomination made those tracks.
                """);
        this.addChoice(new Choice("Grab the knife") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.KNIFE)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                    if (!player.hasItem(Items.KNIFE)) {
                        scene.gameOutput("You walk over to the spruce tree. You manage to shimmy the knife out of its flesh and attach it to your belt. You feel just a litte more secure.");
                        player.addItem(Items.KNIFE);
                    } else {
                        this.makeUnchoosable();
                    }
                    new EventTreeAndTracks().run(player, scene, false);
                };
            }
        );
        this.addChoice(new Choice("Follow the animal tracks") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Against your best judgement, you begin to follow the tracks. As you walk alongside them, you realize that they are easily four times the size of your feet, with sharp protrusions where phalanges would normally be. You hope this wasn't a mistake.");
                if (player.hasItem(Items.KNIFE)) {
                    scene.gameOutput("The small combat knife at you waist is little reassurance.");
                }
            }
        });
        this.addChoice(new Choice("Walk in the opposite direction of the tracks.") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Whatever beast left those tracks, you do not want to find out. ");
                scene.gameOutput("You decide to change your course and head in a different direction.");
                new EventRiverCrossing().run(player, scene, false);
            }
        });
    }
}
