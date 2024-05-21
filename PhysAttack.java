

public class PhysAttack extends Move{

    private int damage;
    
    public PhysAttack(int damage, String name){

        super(name, 0);
        this.damage = damage;
    }

    public void use(Battler user, Battler target){

        target.reduceHP(Math.max((int)(damage * user.getStr()/target.getEnd()), 1));

        System.out.println(result(user, target));

        Music.sound("./audiofiles/bonk.wav");
        
        

    }

    public String getInfo(){
        return String.format("%s\nPhysical Attack, Base Power: %d\n", getName(), damage);
    }

}