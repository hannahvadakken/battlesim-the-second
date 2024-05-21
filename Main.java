import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

  public static ArrayList<Battler> turnOrder = new ArrayList<>(3);

  public static NPC enemy = new Enemy();

  public static PC p1, p2 = null;

  private static int counter;

  public static Inventory inventory;
  public static void main(String[] args) {

    Music.loop("./audiofiles/loop.wav");

    Scanner sc = new Scanner(System.in);

    System.out.println("\n\n\nChoose a class for player one.");
    p1 = characterSelect();

    System.out.println("\nChoose a class for player two.");
    p2 = characterSelect();

    inventory = new Inventory();

    System.out.println("\nAt any point, type '9' to see your characters' stats and move pools.\n\n"); 


    while((p1.getHp() > 0 || p2.getHp() > 0) && enemy.getHp() > 0){

      round();


    }


  }

  private static void round(){

    System.out.println("\n");

    setTurnOrder();

    for(Battler current: turnOrder){
      System.out.println();
      current.yourTurn();

      if(enemy.getHp() <= 0){
        
        break;
        
      }

      if(p1.getHp() <= 0 && p2.getHp() <= 0){

        lose();

      }

    }

    if(enemy.getHp() <= 0){
        
      win();
      
    }


  }

  private static void win(){
    System.out.println(Colors.green("Player victory!\n\n"));

    turnOrder.remove(enemy);
    Music.sound("./audiofiles/win_sound.wav");

    enemy = ++counter % 3 == 0 ? new Boss() : new Enemy();
    
    round();

  }

  private static void lose(){
    System.out.println(Colors.red("Enemy victory :(\n\n"));
    System.exit(0);

  }

  private static PC characterSelect(){

    System.out.println("Type 1 for Brawler, 2 for Cleric, 3 for Mage, or 4 for Thief.");

    switch (readInt(1, 4)) {

      case 1:
        return new Brawler();

      case 2:
        return new Cleric();

      case 3:
        return new Mage();

      case 4:
        return new Thief();

      default:
        System.out.println("Welp. Something has gone very wrong! Defaulting to Brawler.");
        return new Brawler();

    }

  }


  public static int readInt(int lower, int upper){

    Scanner sc = new Scanner(System.in);

    String x = sc.nextLine();

    while (x.length() != 1 || !(x.charAt(0) >= 48 + lower && (x.charAt(0) <= 48 + upper) || (x.charAt(0) == 57 && p1 != null && p2 != null))) {
      System.out.println("\nInvalid input");
      x = sc.nextLine();
      
    }

    int y = Integer.parseInt(x);

    if(y == 9){
      help();
      return readInt(lower, upper);

    }

    return y;
  }

  private static void setTurnOrder(){
    Collections.sort(turnOrder);

  }

  private static void help(){

    System.out.println("What information would you like to see?");
    System.out.println("(0) " + p1.getName() + ", (1) " + p2.getName() + ", (2) Inventory");

    PC player = p1;

    int option = readInt(0, 2);

    if(option == 2){
      System.out.println(inventory.getPrintableInventory());
      return;
    }

    if(option == 1){
      player = p2;
    }

    System.out.println(player.getInfo());

    for(int i = 0; i < 5; i++){
      System.out.println("(" + i + ") " + player.getMove(i).getInfo());
    }

  }

  public static int getCounter(){
    return counter;
  }


}