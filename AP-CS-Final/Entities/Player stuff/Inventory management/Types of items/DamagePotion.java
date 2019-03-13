public class DamagePotion extends Consumable {
  
  private int amount;
  
  public DamagePotion (int amount) {
    price = 20;
    type = 0;
    name = "Damage Potion";
    this.amount = amount;
  }
  
  @Override
  public void useItem(Entity person) {
    person.addDamage(amount);
  }
  
  public String toString() {
    return "Damage Potion(" + amount + ")";
  }
  
}