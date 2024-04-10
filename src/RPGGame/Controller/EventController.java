package RPGGame.Controller;

import RPGGame.Event.Abstracts.Event;

import java.util.ArrayList;

public class EventController {
    ArrayList<Event> eventLog;
    EventController() {
        eventLog = new ArrayList<Event>();
    }
}
