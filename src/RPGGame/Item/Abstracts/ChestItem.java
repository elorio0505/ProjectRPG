package RPGGame.Item.Abstracts;

public abstract class ChestItem extends EquipabbleItem {
  private String itemName; 
  private int defenseRate;

  public ChestItem(String itemName, int defenseRate){ 
    this.itemName = itemName
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

class ChestItem {
  public static void main(String [] args) {
    ChestItem ironBreastPlate = new ChestItem("Iron BreastPlate", 2);
    ChestItem bronzeBreastPlate = new ChestItem("Bronze BreastPlate", 1);
    
    ironBreastPlate.displayItem();
