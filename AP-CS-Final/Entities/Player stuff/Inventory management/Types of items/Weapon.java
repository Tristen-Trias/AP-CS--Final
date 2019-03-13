public abstract class Weapon extends Item {
  
  protected boolean weapon = true;
  
  public void delObj(Object o) {
    o = null;
  }
  
  public boolean isWeapon() {
    return weapon;
  }
  
}