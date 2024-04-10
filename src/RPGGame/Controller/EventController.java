package RPGGame.Controller;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.Encounter;
import RPGGame.Event.Abstracts.Event;
import RPGGame.Event.Abstracts.StoryEvent;

import java.util.ArrayList;

public class EventController {
    ArrayList<Event> eventLog;
    EventController() {
        eventLog = new ArrayList<Event>();
    }

    public StoryEvent createEvent(Player player) {
        return null;
    }

    public Encounter createEncounter(Player player) {
        return null;
    }
}
