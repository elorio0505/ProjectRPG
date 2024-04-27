package RPGGame;
import RPGGame.Controller.PrimaryScene;
import RPGGame.Event.Concrete.StoryEvents.EventStart;

import java.util.ArrayList;
public class Player {
    public String name;

    private ArrayList<Items> items;

    public Player(String name) {
        this.name = name;
        items = new ArrayList<Items>();
    }


    public void die(String message, PrimaryScene scene) {
        scene.gameOutput("---=== YOU DIED! ===---");
        scene.gameOutput(message);
        scene.gameOutput("Enter 1 to play again.");
        while (true) {
            try {
                String input = scene.waitForNewInput();
                if (input.equals("1")){
                    scene.gameOutputClear();
                    new EventStart().run(new Player(this.name),scene, true);
                } else {
                    System.exit(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void addItem(Items i){ //add item to inventory --devin
        if (!items.contains(i)){
            items.add(i);
        }
    }

    public boolean hasItem(Items i){ //check if player has item --devin
        if (items.contains(i)){
            return true;
        } return false;
    }

    public void removeItem(Items i){ //remove item from inventory --devin
        if (items.contains(i)){
            items.remove(i);
        }
    }


}
