package RPGGame.Event.Concrete.StoryEvents;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.StoryEvent;

public class EventGlowingCaveSystem extends StoryEvent {
  EventGlowingCaveSystem() {
    super();
    this.setEventText(""" 
            As you are walking down the glowing moss path, a rock stops you in your tracks.
            """);
    this.setReencounterText("""
            You believe that if you move this rock, you can continue your way onto the path.
            """);
           this.addChoice(new Choice("Move the rock") 
            @Override
            public void execute(Player player, PrimaryScene scene) {
                scene.gameOutput("You were sucessful moving the big rock out of the way and continue on'");
                scene.gameOutput("The path is a dead end and decide to turn back. However, the rock you just moved kept ahold of the cave system entirely. And all the rocks fall to the ground covering up the exit. You try to move the rocks but they are too compact together to move");
                scene.gameOutput("Unfortunately your stuck in this cave forever!");
                scene.gameOutput("---===BAD ENDING===---");
                scene.gameOutput("Enter 1 to play again.");
                while (true) {
                    try {
                        String input = scene.waitForNewInput();
                        if (input.equals("1")){
                            scene.gameOutputClear();
                            new EventStart().run(new Player(player.name),scene, true);
                        } else {
                            System.exit(1);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    
    this.addChoice(new Choice("Go back to the cave entrance") {
      @Override 
      public void execute(Player player, PrimaryScene scene) {
        scene.gameOutput("You decide to go back since you cannot move the rock.");
        new EventCavEntrance().run(player, scene, true);
      }
    });
  }
}
