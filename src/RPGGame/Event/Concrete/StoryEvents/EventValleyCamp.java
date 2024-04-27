package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Event.Abstracts.StoryEvent;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;

public class EventValleyCamp extends StoryEvent { // --devin
    public EventValleyCamp() {
        super();
        this.setEventText("""
                As you cautiously approach the source of the smoke, you discover a small group of survivors gathered around a campfire. Initially, they appear non-hostile, but as you get closer, their demeanor shifts abruptly. They stand up, grabbing rudimentary weapons, and their leader steps forward, eyeing you with suspicion.
                """);

        this.addChoice(new Choice("Pull out the pistol") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.PISTOL)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.AMMO)) {
                    scene.gameOutput("You pull out your pistol, aiming it defensively at the ground. The leader pauses, then signals the others to lower their weapons. Impressed by your show of force, they respect your strength and gift you a box of ammunition. He then tells you the ridge will show you what you seek and warns you he won't be so merciful if you come back.");
                    player.addItem(Items.AMMO);
                    scene.gameOutput("You have received ammunition for your pistol. You head back to camp.");
                    new EventSnowyRidge().run(player, scene, false);
                } else {
                    scene.gameOutput("You should have listened.");
                    player.die("You were turned into a kabob.",scene);
                }
            }
        });

        this.addChoice(new Choice("Pull out the knife") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.KNIFE)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You quickly pull out your knife, holding it ready. The tribes people laugh, clearly not intimidated. 'You think that will save you?' the leader mocks.");
                scene.gameOutput("\"FIRE!\"");
                player.die("You were turned into a kabob", scene);
            }
        });

        this.addChoice(new Choice("Run back to the camp") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Realizing you're outmatched, you turn and sprint back towards the ridge, the sound of shouting fading behind you.");
                new EventSnowyRidge().run(player, scene, false);
            }
        });
    }
}

