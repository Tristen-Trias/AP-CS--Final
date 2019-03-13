
public class Troll extends Entity {
  
  public final String name = "Troll";

  public Troll(int health, int armor, int damage, int speed) {
    this.health = health * 2;
    this.armor = armor * 2;
    this.damage = damage * 2;
    this.speed = speed * 2;
  }

  @Override
  public String getName() {
    return name;
  }

}