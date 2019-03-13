public class Exp {
  
  private int points;
  private int level;
  
  public Exp() {}
  
  public boolean checkLevelUp() {
    if (Math.pow(2, level) < points) {
      level++;
      return true;
    } else {
      return false;
    }
  }
  
  public void addPoints(int points) {
    this.points = points;
  }
  
  public int getLevel() {
    return level + 1;
  }
  
  public int getPoints() {
    return points;
  }
  
}