package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventViewFromTheRidge extends StoryEvent { // --devin
    public EventViewFromTheRidge() {
        super();
        this.setEventText("""
                The climb is arduous and the cold bites into your flesh as you ascend the snowy ridge. Upon reaching the top, you're rewarded with a stunning vista. Below, the forest spreads out like a dark, frozen sea, and the valley with the rising smoke lies clearly visible to the south. To the east, you spot an unusual shimmering light, seemingly out of place in the natural landscape.
                """);

        this.addChoice(new Choice("Investigate the shimmering light") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Driven by curiosity, you head towards the mysterious light. As you approach, the light grows stronger, revealing a metallic structure partially buried in the snow. It appears to be a spacecraft of some sort.");
                new EventTowardsShimmeringLight().run(player, scene, true);
            }
        });

        this.addChoice(new Choice("Descend into the valley towards the smoke") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Deciding to find out more about the source of the smoke, you carefully make your way down the ridge towards the valley. As you get closer, the smell of woodsmoke becomes more pronounced, and you hear faint voices.");
                new EventValleyCamp().run(player, scene, true);
            }
        });

    }
}
