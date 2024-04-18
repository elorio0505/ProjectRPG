package RPGGame.Item.Abstracts;

public abstract class InvItem {
    int value;
    String itemName;
    public InvItem() {
        this.value = value();
        this.itemName = itemName();
    }

    public abstract int value();
    public abstract String itemName();
}
