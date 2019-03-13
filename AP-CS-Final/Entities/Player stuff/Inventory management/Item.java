public abstract class Item {
  
  protected int type;
  protected String name;
  protected boolean isConsumable = false;
  protected int price;
  
  public int getType() { return type; }
  public String getName() { return name; }
  public String toString() { return name; } 
  public boolean isConsumable() { return false; }
  public boolean isWeapon() { return false; }
  public void useItem(Entity entity) {}
  public int getDamage() { return 0; }
  public int getPrice() { return price; }
  
}