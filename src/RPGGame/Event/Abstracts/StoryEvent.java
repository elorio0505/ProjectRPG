package RPGGame.Event.Abstracts;

import RPGGame.Player;
import RPGGame.Controller.PrimaryScene;
import java.util.ArrayList;

public abstract class StoryEvent { // -- erica, devin
    private String eventText;
    private String reencounterText;

    private boolean firstEncounter = true;

    public void setEventText(String eventText) {
        this.eventText = eventText;
    }
    public void setReencounterText(String reencounterText) {
        this.reencounterText = reencounterText;
    }

    //Array of choices
    private ArrayList<Choice> choices;
    private ArrayList<Choice> displayedChoices;

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
        displayedChoices = new ArrayList<Choice>();
    }

    public boolean isFirstEncounter() {
        return firstEncounter;
    }

    public boolean run(Player player, PrimaryScene scene, boolean firstEncounter) {
        this.firstEncounter = firstEncounter;
        if (firstEncounter) { // If this is marked as the first time this event is seen, then the inital introductory text is diplayed.
            scene.gameOutput(eventText);
        } else { // Otherwise, the shorter text is shown.
            scene.gameOutput(reencounterText);
        }
        System.out.println("1");
        int index = 0;
        for (Choice choice : choices) { //display choices --devin
            choice.preExecute(player, scene);
            if (choice.isChoosable()) {
                scene.gameOutput("[" + (index + 1) + "] " + choice.getText());
                displayedChoices.add(choice);
                index++;
            }
        }
        while (true) { //get and execute choice --devin
            try {
                String userInput = scene.waitForNewInput();
                int selectedChoiceIndex = Integer.parseInt(userInput) - 1; // Convert to zero-based index
                if (selectedChoiceIndex >= 0 && selectedChoiceIndex < displayedChoices.size() && displayedChoices.get(selectedChoiceIndex).isChoosable()) {
                    displayedChoices.get(selectedChoiceIndex).execute(player, scene); // Execute the choice action
                    break;
                } else {
                    scene.gameOutput("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException ex) {
                scene.gameOutput("Invalid input. Please enter a number.");
            } catch (InterruptedException ex) {
                scene.gameOutput("Input was interrupted.");
            }
        }
        return true;
    }
}
