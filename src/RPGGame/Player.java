package RPGGame;

public class Player {
    public String name;

    public Player(String name) {
        this.name = name;
    }

    public void die() {
        System.out.println("---=== YOU DIED! ===---");
        System.exit(1);
    }

    public void die(String deathText) {
        System.out.println("---=== YOU DIED! ===---");
        System.out.println(deathText);
        System.exit(1);
    }

}
