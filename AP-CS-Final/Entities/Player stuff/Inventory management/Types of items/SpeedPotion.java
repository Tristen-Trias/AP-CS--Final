public class SpeedPotion extends Consumable {
  
  private int amount;
  
  public SpeedPotion (int amount) {
    price = 20;
    type = 3;
    name = "Speed Potion";
    this.amount = amount;
  }
  
  @Override
  public void useItem(Entity person) {
    person.addSpeed(amount);
  }
  
  public String toString() {
    return "Speed Potion(" + amount + ")";
  }
  
}