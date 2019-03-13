import java.util.*;

public class Shop {
  
  Player player;
  Inventory inv;
  ArrayList<Item> shopinv = new ArrayList<Item>();
  
  public Shop(Player player, Inventory a) {
    this.player = player;
    inv = a;
    randomShopInv();
    instance();
  }
  
  public String toString() {
    String full = "/";
    for (int i = 0; i < shopinv.size(); i++) {
      if (shopinv.get(i) == null) full += "/ Sold /";
      else full += "/ " + shopinv.get(i).toString() + ": " + (shopinv.get(i).getPrice() + 10 ) + " /";
    }
    return "Gold: " + inv.getGold() + "\n" + full + "/";
  }
  
  public void randomShopInv() {
    int rand = (int)(Math.random() * 6);
    int min = 0; 
    int max = 5;
    while(min <= max) {
      if (rand == 0) shopinv.add(new DamagePotion(2));
      else if (rand == 1) shopinv.add(new HealthPotion(10));
      else if (rand == 2) shopinv.add(new MagicPotion(3));
      else if (rand == 3) shopinv.add(new SpeedPotion(2));
      else if (rand == 4) shopinv.add(new ArmorPotion(2));
      else if (rand == 5) shopinv.add(new ThrowKnife(20));
      rand = (int)(Math.random() * 6);
      min++;

    }
  }
  
  public boolean checkMoney(int price) {
    if (inv.getGold() < price) return false;
    else return true;
  }
  
  public void buyItem(Item item) {
    if (checkMoney(item.getPrice() + 10)) {
      inv.subGold(item.getPrice() + 10);
      inv.addItem(item);
      shopinv.set(shopinv.indexOf(item), null);
    } else {
      System.out.println("You don't have money.");
    }
  }
  
  public void instance() {
    
    boolean inShop = true;
    Scanner s = new Scanner(System.in);
    System.out.println("Welcome to the shop! \n");
    System.out.println("What would you like to buy?");
    while (inShop) {
      System.out.println(toString());
      String response = s.nextLine();
      try {
        int temp = Integer.parseInt(response);
        if (temp == 1) buyItem(shopinv.get(0));
        else if (temp == 2) buyItem(shopinv.get(1));
        else if (temp == 3) buyItem(shopinv.get(2));
        else if (temp == 4) buyItem(shopinv.get(3));
        else if (temp == 5) buyItem(shopinv.get(4));
        else if (temp == 6) buyItem(shopinv.get(5));
      } catch (Exception e) {
        if (e instanceof NumberFormatException) {
          inShop = false;
        } else {
          System.out.println("Invalid response.");
        }
      }
      
    }
  }
  
}