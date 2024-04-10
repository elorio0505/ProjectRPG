package RPGGame.Event.Concrete.StoryEvents;

import RPGGame.Entity.Abstracts.Player;
import RPGGame.Event.Abstracts.Choice;
import RPGGame.Event.Abstracts.EventReward;
import RPGGame.Event.Abstracts.StoryEvent;

public class TestEvent extends StoryEvent {

    public TestEvent() {
        eventText = "This is a test event.";
        positiveReward1 = new EventReward() {
            @Override
            public void giveReward(Player player) {
                player.luck += 1;
            }
        };
        negativeReward1 = new EventReward() {
            @Override
            public void giveReward(Player player) {
                player.die();
            }
        };
        choices.add(new Choice() {
            @Override
            public void execute(Player player) {
                positiveReward1.giveReward(player);
            }

            @Override
            public void setText(String text) {
                text = "This is a good choice :)";
            }
        });
        choices.add(new Choice() {
            @Override
            public void execute(Player player) {
                negativeReward1.giveReward(player);
            }

            @Override
            public void setText(String text) {
                text = "This is a bad choice :(";
            }
        });
    }

    @Override
    public boolean run() {
        //TODO: Program events to do their thing
        return false;
    }
}
