

public class Healing extends Move{

    private int healamt;
    
    public Healing(int healamt, String name, int cost){
        super(name, cost);
        this.healamt = healamt;
    }

    public Healing(int healamt, String name){
        this(healamt, name, 0);
    }

    public void use(Battler user, Battler target){
        target.addHP(healamt);
        System.out.println(super.result(user, target));
        Music.sound("./audiofiles/heal.wav");

        if(user instanceof PC){
            ((PC)user).reduceMP(getCost());
        }

    }

    public String getInfo(){
        return String.format("%s\nHealing, Heal Power: %d, MP Cost: %d\n", getName(), healamt, getCost());
    }

}