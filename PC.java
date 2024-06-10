public abstract class PC extends Battler implements GetInfo{

  private int currentMP;
  private final int maxMP;
  private Move curr;
  private Item item;
  public static int count = 0;
  public static boolean finished = false;
  public static boolean itemSel = false;

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

  public boolean buttonPressed(){
    return !(MovePanel.OnePress == false && MovePanel.TwoPress == false && MovePanel.ThreePress == false 
    && MovePanel.FourPress == false && MovePanel.FivePress == false);

  }

  public void oooh(){ //move selection


    System.out.println(this.getMP());

    if(MovePanel.OnePress == true){
      this.curr = getMove(0);
      //curr.use(this, Main.enemy);
      MovePanel.OnePress = false;
    }
    else if(MovePanel.TwoPress == true){
      this.curr = getMove(1);
      //curr.use(this, Main.enemy);
      MovePanel.TwoPress = false;
    }
    else if(MovePanel.ThreePress == true){
      this.curr = getMove(2);
      //curr.use(this, Main.enemy);
      MovePanel.ThreePress = false;
    }
    else if(MovePanel.FourPress == true){
      this.curr = getMove(3);
      //curr.use(this, Main.enemy);
      MovePanel.FourPress = false;
    }
    else if(MovePanel.FivePress == true){
      this.curr = getMove(4);
      //curr.use(this, Main.enemy);
      MovePanel.FivePress = false;
    }

    if(this.getMP() < curr.getCost()){
      curr = null;
      Main.x.showBattle();
      

    }

  }

  public void aaah(){ //target selection
    if(PickTargetPanel.enemy == true){
      this.curr.use(this, Main.enemy);
      PickTargetPanel.enemy = false;
      count = 0;
      //return;
    }
    else if(PickTargetPanel.p1 == true){
      curr.use(this, Main.p1);
      PickTargetPanel.p1 = false;
      count = 0;
      //return;
    }
    else if (PickTargetPanel.p2 == true){
      curr.use(this, Main.p2);
      PickTargetPanel.p2 = false;
      count = 0;
      //return;
    }
  }

  public void yourTurn(){

    if(getHp() <= 0){
      finished = true;
      return;
    }

    System.out.println("What should " + getName() + " do?  ");

    System.out.println("0 for attack, 1 for bag, 9 for info");

    while(ActionPanel.moveSel == false && ActionPanel.bagSel == false){
      System.out.print("");
    }

    if(ActionPanel.moveSel == true){

      curr = null;

      while(curr == null){

        while(buttonPressed() == false){
          System.out.print("");
        }
    
        oooh();

      }
  
      System.out.println("Who would you like to use " + curr.getName() + " on?");
  
      while(count != 1){
        System.out.print("");
      }
  
      aaah();
  
      finished = true;
      ActionPanel.moveSel = false;
      return;
    }
    else if(ActionPanel.bagSel == true){
      System.out.println("What item would you like to use?");

      // while(buttonPressed() == false){
      //   System.out.print("");
      // }

      while(itemSel == false){
        System.out.print("");
      }

      eeeeh();

      System.out.println("Who would you like to use " + item.getName() + " on?");

      while(count != 1){
        System.out.print("");
      }

      uuuh();

      finished = true;
      itemSel = false;
      ActionPanel.bagSel = false;

      checkShop();
      return;
    }

  }

  public void checkShop(){
    while(Choice.selection == false){
      System.out.println("");
    }

    while(Choice.selection == true){
      if(ShopPanel.battling == true){
        return;
      }
      else if(ShopPanel.battling == false){
        System.out.println("");
      }
    }
  }


  public void uuuh(){ //bag enemy selection
    if(PickTargetPanel.enemy == true){
      item.use(this, Main.enemy);
      PickTargetPanel.enemy = false;
      count = 0;
      //return;
    }
    else if(PickTargetPanel.p1 == true){
      item.use(this, Main.p1);
      PickTargetPanel.p1 = false;
      count = 0;
      //return;
    }
    else if (PickTargetPanel.p2 == true){
      item.use(this, Main.p2);
      PickTargetPanel.p2 = false;
      count = 0;
      //return;
    }
  }
  
  public void eeeeh(){ //bag item selection
    if(BagPanel.OnePress == true){
      this.item = Main.inventory.get(0);
      //curr.use(this, Main.enemy);
      BagPanel.OnePress = false;
      return;
    }
    else if(BagPanel.TwoPress == true){
      this.item = Main.inventory.get(1);
      //curr.use(this, Main.enemy);
      BagPanel.TwoPress = false;
      return;
    }
    else if(BagPanel.ThreePress == true){
      this.item = Main.inventory.get(2);
      //curr.use(this, Main.enemy);
      BagPanel.ThreePress = false;
      return;
    }
    else if(BagPanel.FourPress == true){
      this.item = Main.inventory.get(3);
      //curr.use(this, Main.enemy);
      BagPanel.FourPress = false;
      return;
    }
    else if(BagPanel.FivePress == true){
      this.item = Main.inventory.get(4);
      //curr.use(this, Main.enemy);
      BagPanel.FivePress = false;
      return;
    }
  }

    //return;
    

  //   int choice = Main.readInt(0, 1);
    
  //   if(choice == 0){

  //     System.out.println(this.getPrintableMovePool());
      
  //     Move currentMove = getMove(Main.readInt(0, 4));

  //     while(currentMove.getCost() > this.getMP()){

  //       System.out.println("Not enough mana!");
  //       currentMove = getMove(Main.readInt(0, 4));
          
  //     }

  //     System.out.println("Who would you like to use " + currentMove.getName() + " on?");
        
  //     for(int i = 0; i < Main.turnOrder.size(); i++){
  //       System.out.println(String.format("(%d) %s // ", i, Main.turnOrder.get(i).getName()));
  //     }

  //     Battler target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size() - 1));

  //     while(target.getHp() <= 0){
  //       System.out.println("Target is dead!");
  //       target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size()));

  //     }
      
  //     currentMove.use(this, target);

    
  // } else {

  //   if(Main.inventory.size() <= 0){
  //     System.out.println("Inventory is empty!");
  //     yourTurn();
  //     return;

  //   }
    
  //   System.out.println(Main.inventory.getPrintableInventory());

  //   Item theItemInQuestion = Main.inventory.get(Main.readInt(0, Main.inventory.size()));

  //   System.out.println("Who would you like to use " + theItemInQuestion.getName() + " on?");
        
  //   for(int i = 0; i < Main.turnOrder.size(); i++){
  //     System.out.println(String.format("(%d) %s // ", i, Main.turnOrder.get(i).getName()));
  //   }

  //   Battler target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size() - 1));

  //   while(target.getHp() <= 0){
  //     System.out.println("Target is dead!");
  //     target = Main.turnOrder.get(Main.readInt(0, Main.turnOrder.size()));

  //   }


  //   theItemInQuestion.use(this, target);



  // }

}