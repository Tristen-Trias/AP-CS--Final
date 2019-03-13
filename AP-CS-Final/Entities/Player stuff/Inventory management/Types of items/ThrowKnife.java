public class ThrowKnife extends Weapon {
  
  private int dmg;
  
  public ThrowKnife(int dmg) {
    type = 5;
    this.dmg = dmg;
  }
  
  public void useItem(Entity entity) {
    entity.subHealth((dmg + 10) - entity.getArmor());
  } 
  
  @Override
  public int getDamage() {
    return dmg + 10;
  }
  
  public String toString() {
    return "Throwing Knife(" + (dmg + 10) + ")";
  }
  
}