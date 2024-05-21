
public class Boss extends NPC{

  public Boss(){
    super(8,(int)(Math.random() * 3 + 6) ,(int)(Math.random() * 3 + 6) ,(int)(Math.random() * 3 + 6) ,(int)(Math.random() * 3 + 6) ,(int)(Math.random() * 3 + 6) , "OOP");

    addToMovePool(new SpAttack(3, "Acid Spray"));
    addToMovePool(new Debuff('e', "Screech"));
    addToMovePool(new PhysAttack(3, "Explosion"));
    addToMovePool(new Debuff('w', "Acid Tears")); //what's with ur weird obsession with acid
    addToMovePool(new SpAttack(3, "Slimezooka"));

    Music.sound("./audiofiles/Reuniclus.wav");

  }
    
}