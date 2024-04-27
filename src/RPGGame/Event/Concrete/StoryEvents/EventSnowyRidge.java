package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Items;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventSnowyRidge extends StoryEvent { // --devin
    public EventSnowyRidge() {
        super();
        this.setReencounterText("""
                Ahh this place feels like home... Ha! Who am I kidding?""");
        this.setEventText("""
                As the adrenaline from your encounter with the moose subsides, you find yourself standing at the base of a steep, snowy ridge. There's a small overhang that might work as a makeshift base. The air feels thinner here, and the landscape opens up to reveal a panoramic view of the snow-covered wilderness. In the distance, you notice what appears to be smoke rising from a small valley.
                """);

        this.addChoice(new Choice("Climb the ridge") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("With effort, you begin your ascent. The snow makes the climb treacherous, but the view from the top could provide valuable insights into your surroundings.");
                new EventViewFromTheRidge().run(player, scene, true);
            }
        });

        this.addChoice(new Choice("Head towards the smoke") {
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Curious about the source of the smoke, you decide to make your way towards the valley. As you descend into the valley, the smell of woodsmoke grows stronger.");
                new EventValleyCamp().run(player, scene, true);
            }
        });

        if (this.isFirstEncounter()) {
        this.addChoice(new Choice("Set up a temporary camp here") {
            @Override
            public void preExecute(Player player, PrimaryScene scene) {
                if (player.hasItem(Items.PISTOL)) {
                    this.makeUnchoosable();
                }
            }

            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("Deciding to rest, you set up a small, temporary camp. The cold is biting, but you manage to gather enough wood for a modest fire. While scavenging, you find a pistol. It's rusty, and there's no ammo.");
                player.addItem(Items.PISTOL);
                new EventSnowyRidge().run(player,scene,false);
            }
        });
        }
    }
}
