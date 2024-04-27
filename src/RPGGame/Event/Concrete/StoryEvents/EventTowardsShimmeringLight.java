package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventTowardsShimmeringLight extends StoryEvent { // --devin
    public EventTowardsShimmeringLight() {
        super();
        this.setEventText("""
                The path towards the shimmering light grows increasingly treacherous, but the snowfall periodically settles. The snow deepens, and the air grows chillier with each step. As you draw nearer, the light pulses rhythmically, casting eerie shadows across the snow. The outline of the underlying metallic structure beneath looms ominously, its exterior reflecting the light in an array of bizarre, shifting patterns. Memorized, you almost fail to hear the distinct sound of crushed of snow encroaching from behind you.
                """);

        this.addChoice(new Choice("Continue towards the light") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You press forward. As you reach the base of the structure, you are struck from behind.");
                player.die("You got pummeled", scene);
            }
        });

        this.addChoice(new Choice("Turn around") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("As you spin around, a shadow looms over you, enormous and foreboding. The silhouette, whether beast or machine, charges forward, metallic glints hinting at a mechanical nature.");
                scene.gameOutput("Caught off guard, you can only react as the creature closes the distance, its form becoming clearer each second.");
                new EventMooseAmbush().run(player, scene, true);
            }
        });

    }
}