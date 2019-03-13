public class ArmorPotion extends Consumable {
  
  private int amount;
  
  public ArmorPotion (int amount) {
    price = 20;
    type = 4;
    name = "Armor Potion";
    this.amount = amount;
  }
  
  @Override
  public void useItem(Entity person) {
    person.addArmor(amount);
  }
  
  public String toString() {
    return "Armor Potion(" + amount + ")";
  }
  
}