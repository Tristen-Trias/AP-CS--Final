public class HealthPotion extends Consumable {
  
  private int amount;
  
  public HealthPotion(int amount) {
    price = 5;
    type = 1;
    name = "Health Potion";
    this.amount = amount;
  }
  
  @Override
  public void useItem(Entity person) {
    person.addHealth(amount);
  }
  
  public String toString() {
    return "Health Potion(" + amount + ")";
  }
  
}