package RPGGame.Entity.Abstracts;

import RPGGame.Controller.SceneController;

public abstract class Enemy extends Entity {
    protected String name;
    int lootMoney;

    public Enemy(int lootMoney) {
        this.lootMoney = lootMoney;
    }

    @Override
    public void die(Player player) {
        super.die(player);
        player.gold += lootMoney;
        SceneController.gameTextAreaNewLine(name + " has perished, and dropped " + lootMoney + " gold!");
    }

    public abstract void onTurn(Player player, int turnNumber);
}
