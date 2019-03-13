public class MagicPotion extends Consumable {
  
  private int amount;
  
  public MagicPotion (int amount) {
    price = 50;
    type = 2;
    name = "Magic Potion";
    this.amount = amount;
  }
  
  @Override
  public void useItem(Entity person) {
    person.addMagic(amount);
  }
  
  public String toString() {
    return "Magic Potion(" + amount + ")";
  }
  
}