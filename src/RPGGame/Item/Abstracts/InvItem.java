package RPGGame.Item.Abstracts;

// TODO complete implementation
public abstract class InvItem {
    int value;
    public InvItem() {
        this.value = value();
    }

    public abstract int value();
}
