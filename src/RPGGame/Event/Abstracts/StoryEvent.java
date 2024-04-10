package RPGGame.Event.Abstracts;

import java.util.ArrayList;

public abstract class StoryEvent extends Event {
    // Defines the rewards that can be chosen from for the event. Not all of these values need to be used per event.
    public EventReward positiveReward1;
    public EventReward positiveReward2;
    public EventReward negativeReward1;
    public EventReward negativeReward2;
    public String eventText;
    //Array of choices
    public ArrayList<Choice> choices;
}
