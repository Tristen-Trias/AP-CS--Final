public abstract class Entity {
  
  protected int health, armor, damage, speed, magic, points;
  protected String name;
  
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }

  public int getHealth() { return health; }
  public int getArmor() { return armor; }
  public int getDamage() { return damage; }
  public int getSpeed() { return speed; }
  public int getMagic() { return magic; }
  
  public void setHealth(int amount) { health = amount; }
  public void setArmor(int amount) { armor = amount; }
  public void setDamage(int amount) { damage = amount; }
  public void setSpeed(int amount) { speed = amount; }
  public void setMagic(int amount) { magic = amount; }
  
  public void addHealth(int amount) { health += amount; }
  public void addArmor(int amount) { armor += amount; }
  public void addDamage(int amount) { damage += amount; }
  public void addSpeed(int amount) { speed += amount; }
  public void addMagic(int amount) { magic += amount; }
  
  public void subHealth(int amount) { health -= amount; }
  public void subArmor(int amount) { armor -= amount; }
  public void subDamage(int amount) { damage -= amount; }
  public void subSpeed(int amount) { speed -= amount; }
  public void subMagic(int amount) { magic -= amount; }
 
  public int getExPoints() { return points; }
  
  public String toString() { return ""; }
  
}