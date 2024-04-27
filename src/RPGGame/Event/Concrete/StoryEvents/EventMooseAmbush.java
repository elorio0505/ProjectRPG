package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventMooseAmbush extends StoryEvent { // --devin
    public EventMooseAmbush() {
        super();
        this.setEventText("""
                As you face the looming figure, its form becomes clear under the fading light. A mechanical monstrosity, part moose, part machine, its limbs fitted with sharp, gleaming metal, and eyes glowing a sinister red. It stomps the ground, preparing to charge.
                """);

        this.addChoice(new Choice("Try to run away") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You turn and attempt to sprint away, but the creature is swift. It quickly catches up, and you feel a heavy blow to your back.");
                player.die("Overwhelmed by the beast, your escape fails.", scene);
            }
        });

        this.addChoice(new Choice("Wave your knife to reflect the sunlight") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.KNIFE)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You pull out your knife and wave it frantically, catching the sun's rays. The reflection hits the creature's eyes, disorienting it momentarily.");
                scene.gameOutput("Taking advantage of its confusion, you carefully back away until it's no longer a threat. You continue towards the shimmering light");
                new EventAlienCraftDiscovery().run(player,scene,true);
            }
        });

        this.addChoice(new Choice("Use your gun") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.PISTOL)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.AMMO)) {
                    scene.gameOutput("You aim your pistol and fire. The shots ring out, you fire until you are out of ammo, then add a more clicks for good measure");
                    scene.gameOutput("The beast drops. It's wearing an amulet around its neck, you decide to pocket it as a reward.");
                    player.addItem(Items.AMULET);
                    player.removeItem(Items.AMMO);
                    new EventAlienCraftDiscovery().run(player,scene,true);
                } else {
                    scene.gameOutput("You pull the trigger, but only hear the empty click of the hammer. The creature doesn't hesitate, charging forward.");
                    player.die("Without ammunition, your gun is useless, and the creature quickly overpowers you.", scene);
                }
            }
        });

        this.addChoice(new Choice("Attack with the knife") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (!player.hasItem(Items.KNIFE)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("In desperation, you pull out your knife and charge at the beast, hoping to find a weak spot in its mechanical armor.");
                scene.gameOutput("Your efforts are futile as the knife merely scrapes against the hard metal without causing any significant damage. The creature reacts swiftly, knocking you to the ground.");
                player.die("Your attempt to fight the beast with a knife ends tragically.", scene);
            }
        });
    }
}
