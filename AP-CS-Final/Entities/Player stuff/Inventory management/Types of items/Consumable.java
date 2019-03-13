public abstract class Consumable extends Item {
  
  protected boolean unused;
  protected boolean consumable = true;
  
  public void delObj(Object o) {
    o = null;
  }
  
  public boolean isConsumable() {
    return consumable;
  }
  
}