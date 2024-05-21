

public abstract class NPC extends Battler{

  public NPC(int h, int s, int e, int d, int w, int m, String name){
    
    super(h, s, e, d, w, m, name, Colors.red);
    System.out.println("A wild " + getName() + " has appeared!");


    
  }

  public void yourTurn(){

    Math.random();

    int target;

    if(Main.p1.getHp()  > 0 && Main.p2.getHp() > 0){
      target = (int)(Math.random() * 2);

    } else if(Main.p1.getHp() <= 0){
      target = 1;

    } else{
      target = 0;

    }

    int move = (int)(Math.random() * 5);

    getMove(move).use(this, target == 0 ? Main.p1 : Main.p2);



    
  }
}