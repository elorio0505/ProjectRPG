package RPGGame.Controller;

import RPGGame.Event.Abstracts.GeneratedEvent;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.Event;
import RPGGame.Event.Abstracts.StoryEvent;

import java.util.ArrayList;

public class EventController {
    ArrayList<Event> eventLog;
    EventController() {
        eventLog = new ArrayList<Event>();
    }

    String[] placeDescriptions = {
            "You find yourself on a wide expanse of snow-covered flatland. The snow sparkles under the weak sunlight, and distant hills form a cold, stark horizon.",
            "A thick fog rolls over a frozen creek. The ice beneath your feet cracks ominously, and the air is filled with the crisp sound of running water from beneath.",
            "Surrounded by towering ice-covered pines, the snow here is undisturbed, save for the occasional animal tracks that disappear into the woods.",
            "You arrive at a small, snow-filled meadow. The quiet is almost overwhelming, but the occasional distant howl reminds you that you are not alone.",
            "An icy wind sweeps across a narrow mountain pass. Each side of the pass is lined with steep, snow-laden slopes, offering little in terms of shelter.",
            "You come across an old, snowed-in campsite. A few pieces of equipment are still visible above the snow, glittering slightly as if recently uncovered.",
            "The trail leads you to the edge of a dense forest. The trees stand so close together that the path forward looks like a dark, forbidding tunnel.",
            "Standing beside a partially frozen river, you watch as chunks of ice slowly drift by. The bank on the other side looks promising but perilously far.",
            "In the shadow of a large, snow-covered rock formation, you find a surprisingly sheltered spot. The snow around the rocks is disturbed, suggesting recent activity.",
            "A sharp ridge overlooks a valley shrouded in mist. The view is breathtaking, but the eerie quiet suggests that this might be a hunting ground."
    };

    // Example choices related to these descriptions
    Choice[] genericEventChoices = {
            new Choice("Continue Walking"){

                @Override
                public void execute(Player player, PrimaryScene scene) {
                    EventController.createEvent();
                }
            },
        new Choice("Examine the glint in the snow") {
            @Override
            public void execute(Player player, PrimaryScene scene) {

            }
        }
    };


    public static GeneratedEvent createEvent() {
        return new GeneratedEvent();

    }

}
