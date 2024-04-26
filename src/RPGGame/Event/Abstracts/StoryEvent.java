package RPGGame.Event.Abstracts;

import RPGGame.Controller.GameController;
import RPGGame.Player;
import RPGGame.Controller.PrimaryScene;
import java.util.ArrayList;

public abstract class StoryEvent extends Event {
    private String eventText;

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    //Array of choices
    private ArrayList<Choice> choices;

    public void addChoice(Choice c) {
        choices.add(c);
    }

    public String getEventText() {
        return eventText;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public StoryEvent() {
        choices = new ArrayList<Choice>();
    }

    @Override
    public boolean run(Player player, PrimaryScene scene) {  //rewrote this to use UI instead of console --devin
        scene.gameTextAreaNewLine(eventText); //display event info
        System.out.println("1");
        int index = 0;
        for (Choice choice : choices) { //display choices --devin
            if (choice.isChoosable()) {
                scene.gameTextAreaNewLine("[" + (index + 1) + "] " + choice.getText());
                index++;
            }
        }
    while (true) { //get and execute choice --devin
        try {
            String userInput = scene.waitForNewInput();
            int selectedChoiceIndex = Integer.parseInt(userInput) - 1; // Convert to zero-based index
            if (selectedChoiceIndex >= 0 && selectedChoiceIndex < choices.size() && choices.get(selectedChoiceIndex).isChoosable()) {
                choices.get(selectedChoiceIndex).execute(player, scene); // Execute the choice action
                break;
            } else {
                scene.gameTextAreaNewLine("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException ex) {
            scene.gameTextAreaNewLine("Invalid input. Please enter a number.");
        } catch (InterruptedException ex) {
            scene.gameTextAreaNewLine("Input was interrupted.");
        }
    }
        return true;
    }

}
