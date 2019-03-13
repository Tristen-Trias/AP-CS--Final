import java.util.*;

public class Run {

  Player a = new Player();
  String temp;
  Scanner s = new Scanner(System.in);
  public Run() {

    Inventory inv = new Inventory (5);
    inv.setGold(100);

    System.out.println("Welcome to our text based adventure game project!\n\n");

    setPlayer();
    a.check();
    clearScreen ();

    System.out.println ("Here's the Shop:");
 
    Shop b = new Shop(a,inv);
    
    clearScreen ();
    System.out.println(a.toString());
    System.out.println (inv);
    System.out.println ("\nThis is your current inventory.\nWe're now sending you into a battle simulator...\n\n");
    Battle simulate = new Battle(a);

  }

  public void setPlayer() {
    boolean done = true;
    System.out.print("What is your name?: ");
    a.setName(s.nextLine());
    System.out.println("\nWelcome " + a.getName() + "!");
    System.out.println("\nDistribute your skill points...(5)");
    disPoints(5);
  }

  public void clearScreen(){
    for(int k = 0; k < 100; k++){
      System.out.println("");
    }
  }
  
  public void disPoints(int skillPoints) {
    if (skillPoints < 1) { 
      System.out.println("-----------------------------------------------------");
      System.out.println("=====================================================");
      System.out.println("-----------------------------------------------------\n\n\n");
    } else {
        System.out.println("You have -" + skillPoints + "- skill points left.\n\n" );

        System.out.println("(H)ealth: " + a.hPoints);
        System.out.println("(A)rmor: " + a.aPoints);
        System.out.println("(D)amage: " + a.dPoints);
        System.out.println("(S)peed: " + a.sPoints);
        System.out.println("(M)agic: " + a.mPoints);

        System.out.println("Select where to put one point.");
      try {
        temp = s.nextLine();
        if (temp.equalsIgnoreCase("h")) {
          a.hPoints++;
          disPoints(skillPoints - 1);
        } else if (temp.equalsIgnoreCase("a")) {
          a.aPoints++; 
          disPoints(skillPoints - 1);
        } else if (temp.equalsIgnoreCase("d")) {
          a.dPoints++;
          disPoints(skillPoints - 1);
        } else if (temp.equalsIgnoreCase("s")) {
          a.sPoints++;
          disPoints(skillPoints - 1);
        } else if (temp.equalsIgnoreCase("m")) {
          a.mPoints++;
          disPoints(skillPoints - 1);
        } else if (temp.equalsIgnoreCase("b")) {
          remPoint(temp);
          disPoints(skillPoints + 1);
        } else {
          System.out.println("Please type H, A, D, S, or M.");
          disPoints(skillPoints);
        }

      } catch (Exception e) {
        System.out.println("Invalid response.");
        disPoints(skillPoints);
      }
    }
  }

  public void remPoint(String x) {
    if (x.equalsIgnoreCase("h")) a.hPoints--;
    else if (x.equalsIgnoreCase("a")) a.aPoints--;
    else if (x.equalsIgnoreCase("d")) a.dPoints--;
    else if (x.equalsIgnoreCase("s")) a.sPoints--;
    else if (x.equalsIgnoreCase("m")) a.mPoints--;
  }
}