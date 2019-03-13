public class Goblin extends Entity {
  
  public final String name = "Goblin";

  public Goblin(int health, int armor, int damage, int speed) {
    this.health = health;
    this.armor = armor;
    this.damage = damage;
    this.speed = speed;
  }

  @Override
  public String getName() {
    return name;
  }

}