import java.util.*;

public class Battle {
  
  private Scanner s = new Scanner(System.in);
  private String pResponse;
  private boolean inBattle;
  private int turns;
  Player player;
  Entity enemy;
  Inventory inv = new Inventory();
  
  public Battle(Player player, Entity enemy) {
    this.player = player;
    this.enemy = enemy;
    player.checkHealth();
    inBattle = true;
    turns = 0;
    System.out.println("You have encountered a " + enemy.getName() + "!");
    startBattle();
  }

  public Battle(Player player) {
    this.player = player;
    int rand = (int)(Math.random() * 3);
    inBattle = true;
    if (rand == 0) enemy = new Goblin(player.getHealth() - 10, player.getArmor() - 2, player.getDamage() - 2, player.getSpeed() - 5);
    else if (rand == 1) enemy = new Dragon(player.getHealth() + 10, player.getArmor(), player.getDamage() + 2, player.getSpeed() + 10, player.getMagic());
    else if (rand == 2) enemy = new Troll(player.getHealth() - 10, player.getArmor() - 2, player.getDamage() - 2, player.getSpeed() - 5);
    System.out.println("You have encountered a " + enemy.getName() + "!");
    startBattle();
  }
  
  public void standardPHit() {
    int hit = player.getDamage() - enemy.getArmor();
    if (hit <= 0) {
      System.out.println("You hit for 0.");
    } else {
      System.out.println("You hit for " + hit + ".");
      enemy.setHealth(enemy.getHealth() - hit);
    }
  }
  
  public void standardEnHit() {
    int hit = enemy.getDamage() - player.getArmor();
    if (hit <= 0) {
      System.out.println("You got hit for 0.");
    } else {
      System.out.println("You got hit for " + hit + ".");
      player.setHealth(player.getHealth() - hit);
    }
  }
  
  public void standardHitSeq() {
    System.out.println("\n");
    if (player.getSpeed() > enemy.getSpeed()) {
      standardPHit();
      standardEnHit();
    } else {
      standardEnHit();
      standardPHit();
    }
  }
  
  public boolean checkDeath() {
    if (enemy.getHealth() <= 0 || player.getHealth() <= 0) return false;
    else return true;
  }
  
  public void accessInventory() {
    boolean inInv = true;
    System.out.println("\n" + inv.toString());
    while (inInv) {
      System.out.println("\nSelect item you want to use (1 - 5). Press enter to exit.");
      pResponse = s.nextLine();
      
      try {
        
        int temp = Integer.parseInt(pResponse);
        Item tempItem = inv.getItem(temp - 1);
        
        if (tempItem == null) {
          System.out.println("\nYou cannot use 'nothing'.");
        } else if (tempItem.isConsumable()) {
          tempItem.useItem(player);
          inv.removeItem(tempItem);
          player.checkHealth();
          inInv = false;
        } else if (tempItem.isWeapon()) {
          tempItem.useItem(enemy);
          System.out.println("\nYou hit for " + (tempItem.getDamage() - enemy.getArmor()) + ".");
          inv.removeItem(tempItem);
          inInv = false;
        }
        
      } catch (Exception e) {
        if (e instanceof NumberFormatException) {
          inInv = false;
        } else {
          System.out.println("\nThat does not exist.");
        }
      }
      
    }
  }
  
  public void startBattle() {
    
    while (inBattle) {
      
      System.out.println("\nYour health: " + player.getHealth());
      System.out.println("Enemy health: " + enemy.getHealth());
      

      System.out.println("\nWhat would you like to do? (Hit, Inv)");
      pResponse = s.nextLine();
      
      if (pResponse.equalsIgnoreCase("Hit")) {
        clearScreen();
        standardHitSeq();
      } else if (pResponse.equalsIgnoreCase("Inv")) {
        clearScreen();
        accessInventory();
      } else {
        clearScreen();
        System.out.println("Invalid response.");
      }
      
      if (!checkDeath()) {
        if (enemy.getHealth() <= 0) {
          System.out.println("\nYou win.");
          System.out.println("Your Health: " + player.getHealth());
          player.addPoints(enemy.getExPoints() * player.getLevel() + 10);
          if (player.checkLevelUp()) {
            System.out.println("You have leveled up! You are now level "+ player.getLevel() + ".");
            System.out.println("\n" + player.toString());
          }
        }
        else System.out.println("\nYou died!");
        inBattle = false;
      }
      
    }
    
  }
  
  public void clearScreen(){
    for(int k = 0; k < 100; k++){
      System.out.println("");
    }
  }
  
}