package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventRiverCrossing extends StoryEvent {
  EventRiverCrossing() {
    super();
    this.setEventText(""" You come across a wide river blocking your path. The current is strong, and the water looks icy cold. You can see a fallen log that spans the river, but it looks old and rotten. On the other side, you spot what seems to be a shortcut to your destination.""");
    this.setReencounterText(""" The river still rages in front of you, and the log remains the only visible way across. """);
    this.addChoice(new Choice("Attempt to cross the log") {
      @Override 
      public void execute(Player player, PrimaryScene scene) {
        scene.gameOutput("You carefully step onto the log, feeling it wobble under your weight. You make it halfway when the log suddenly snaps, sending you tumbling into the cold water.");
      }
    });
    this.addChoice(new Choice("Find a safe place to camp and rest") {
      @Override 
      public void execute(Player player, PrimaryScene scene) {
        scene.gameOutput("You decide to set up camp for the night, hoping the river will be safe to cross in the morning.");
      }
    });
  }
}
