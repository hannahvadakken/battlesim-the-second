

public class SpAttack extends Move{

    private int damage;
    
    public SpAttack(int damage, String name, int cost){

        super(name, cost);
        this.damage = damage;
    }

    public SpAttack(int damage, String name){

        this(damage, name, 0);
    }

    public void use(Battler user, Battler target){

        target.reduceHP(Math.max((int)(damage * user.getMag()/target.getWar()), 1));

        System.out.println(result(user, target));

        Music.sound("./audiofiles/fire-magic-6947.wav");

        if(user instanceof PC) ((PC)user).reduceMP(getCost());


    }

    public String getInfo(){
        return String.format("%s\nSpecial Attack, Base Power: %d\n", getName(), damage);
    }
}