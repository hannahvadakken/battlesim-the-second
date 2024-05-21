public abstract class PC extends Battler implements GetInfo{

  private int currentMP;
  private final int maxMP;

  public PC(int h, int s, int e, int d, int w, int m, String name, int maxMP) {

    super(h, s, e, d, w, m, name, Colors.cyan);

    this.maxMP = maxMP;
    this.currentMP = maxMP;

  }

  public int getMP() {
    return currentMP;
  }

  public void addMP(double regenAmt){
    currentMP += regenAmt;

    if(currentMP > maxMP) currentMP = maxMP;

  }

  public void regenMP() {
    addMP(getWar()/2);

  }

  public void reduceMP(int a) {
    currentMP -= a;
  }

  public String getInfo(){
    return String.format("\n%s\nMoves: [%s]\nStats: [%s, MP: %d]", getName(), getPrintableMovePool(), getPrintableStats(), currentMP);
  }

  public void yourTurn(){

    if(getHp() <= 0){
      return;
    }

    System.out.print("What should " + getName() + " do?  ");

    System.out.println("0 for attack, 1 for bag, 9 for info");

    int choice = Main.readInt(0, 1);
    
    if(choice == 0){

      System.out.println(this.getPrintableMovePool());
      
      Move currentMove = getMove(Main.readInt(0, 4));

      while(currentMove.getCost() > this.getMP()){

        System.out.println("Not enough mana!");
        currentMove = getMove(Main.readInt(0, 4));
          
      }

      System.out.println("Who would you like to use " + currentMove.getName() + " on?");
        
      for(int i = 0; i < Main.turnOrder.size(); i++){
        System.out.print(String.format("(%d) %s // ", i, Main.turnOrder.get(i).getName()));
      }

      Battler target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size() - 1));

      while(target.getHp() <= 0){
        System.out.println("Target is dead!");
        target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size()));

      }
      
      currentMove.use(this, target);

    
  } else {

    if(Main.inventory.size() <= 0){
      System.out.println("Inventory is empty!");
      yourTurn();
      return;

    }
    
    System.out.println(Main.inventory.getPrintableInventory());

    Item theItemInQuestion = Main.inventory.get(Main.readInt(0, Main.inventory.size()));

    System.out.println("Who would you like to use " + theItemInQuestion.getName() + " on?");
        
    for(int i = 0; i < Main.turnOrder.size(); i++){
      System.out.print(String.format("(%d) %s // ", i, Main.turnOrder.get(i).getName()));
    }

    Battler target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size() - 1));

    while(target.getHp() <= 0){
      System.out.println("Target is dead!");
      target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size()));

    }


    theItemInQuestion.use(this, target);



  }
}

}