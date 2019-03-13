public class Player extends Entity {
  
  private Exp experience = new Exp();

  public static final int hRat = 10; //   These are the ratios for each of
  public static final int aRat = 1;  //   stats. So when you level up, you
  public static final int dRat = 1;  //   can distribute skill points, which
  public static final int sRat = 1;  //   raise each stat by these ratios.
  public static final int mRat = 3;  //

  private int bHealth = 50;

  public int hPoints, aPoints, dPoints, sPoints, mPoints = 0;

  public Player() {
    health = 50;
    armor = 5;
    damage = 10;
    speed = 5;
    magic = 5;
    check();
  }
  
  public String toString() {
    return "\nCurrent level: " + experience.getLevel() + "\nHealth: " + health + " \nArmor: " + armor + " \nDamage: " + damage + " \nSpeed: " + speed + " \nMagic: " + magic;
  }
  
  public void addPoints(int points) {
    experience.addPoints(points);
  }
  
  public int getLevel() {
    return experience.getLevel();
  }
  
  public boolean checkLevelUp() {
    if (experience.checkLevelUp()) {
      setHealth(health + 10);
      setArmor(armor + 2);
      setDamage(damage + 4);
      setSpeed(speed + 2);
      setMagic(magic + 1);
      return true;
    } else {
      return false;
    }
  }
  
  public void checkHealth() {
   if (health > bHealth) {
     health = bHealth;
   } else if (health < 0) {
     health = 0;
   }
  }
  
  public void check() {
    health += hPoints * hRat;
    armor += aPoints * aRat;
    damage += dPoints * dRat;
    speed += sPoints * sRat;
    magic += mPoints * mRat;
  }

}
