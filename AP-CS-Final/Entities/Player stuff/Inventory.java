import java.util.*;

public class Inventory {
  
  private static ArrayList<Item> inv = new ArrayList<Item>();
  private int maxSlots;
  public static int money;
  
  public Inventory(int maxSlots) {
    this.maxSlots = maxSlots;
    for (int i = 0; i < maxSlots; i++) {
      inv.add(null);
    }
  }
  
  public Inventory() {}
  
  public int getSlots() {
    return maxSlots;
  }
  
  public Item getItem(int slot) {
    return inv.get(slot);
  }
  
  public void addItem(Item item) {
    boolean hasItem = true;
    for (int i = 0; i < maxSlots; i++) {
      if (inv.get(i) == null && hasItem) {
        inv.set(i, item);
        hasItem = false;
      }
    }
    if (hasItem) System.out.println("Inventory is full!");
  }
  
  public void removeItem(Item item) {
    boolean hasItem = true;
    for (int i = 0; i < inv.size(); i++) {
      if (inv.get(i) == item && hasItem) {
        inv.set(i, null);
        hasItem = false;
      }
    }
  }
  
  public String toString() {
    String full = "|";
    for (int i = 0; i < inv.size(); i++) {
      if (inv.get(i) == null) full += "| Open |";
      else full += "| " + inv.get(i).toString() + " |";
    }
    return "Gold: " + money + "\n" + full + "|";
  }
  
  public void setGold(int amount) { money = amount; }
  public void addGold(int amount) { money += amount; }
  public void subGold(int amount) { money -= amount; }
  public int getGold() { return money; }
  
}
