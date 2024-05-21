

public class Enemy extends NPC{
    public Enemy(){
        super(5,(int)(Math.random() * 3 + 5) ,(int)(Math.random() * 3 + 5) ,(int)(Math.random() * 3 + 5) ,(int)(Math.random() * 3 + 5) ,(int)(Math.random() * 3 + 5) , "Javafx");

        addToMovePool(new SpAttack(3, "Acid Spray"));
        addToMovePool(new Debuff('e', "Screech"));
        addToMovePool(new PhysAttack(3, "Explosion"));
        addToMovePool(new Debuff('w', "Acid Tears")); //what's with ur weird obsession with acid
        addToMovePool(new SpAttack(3, "Slimezooka"));

        if(Main.getCounter() < 2){
            Music.sound("./audiofiles/Solosis.wav");
        } else {
            Music.sound("./audiofiles/Duosion.wav");
        }
        
    }
}