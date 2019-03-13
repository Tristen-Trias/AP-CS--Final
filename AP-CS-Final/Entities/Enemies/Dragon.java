
public class Dragon extends Entity {

  public final String name = "Dragon";

  public Dragon(int health, int armor, int damage, int speed, int magic) {
    this.health = health;
    this.armor = armor;
    this.damage = damage;
    this.speed = speed;
    this.magic = magic;
  }

  public int fireball() {
    return magic;
  }

  @Override
  public String getName() {
    return name;
  }

}