package RPGGame.Item.Abstracts;

public abstract class ChestItem extends EquipabbleItem {
  private int defenseRate;

  public ChestItem(String itemName, int defenseRate) {
    this.itemName = itemName;
    this.defenseRate = defenseRate;
  }

  public String getItemName() {
    return itemName;
  }

  public int getDefenseRate() {
    return defenseRate;
  }

  public void displayItem() {
    System.out.println("Item Name: " + itemName + ", Defense Rate: +" + defenseRate);
  }
}
