package RPGGame.Entity.Abstracts;

public abstract class Enemy extends Entity {
    int lootMoney;

    public Enemy(int lootMoney) {
        this.lootMoney = lootMoney;
    }

    public abstract void onTurn(Player player, int turnNumber);
}
