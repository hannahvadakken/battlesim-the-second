

public class SpecialMove extends Move{

    private int damage;
    private int c;
    
    public SpecialMove(int damage, String name){

        super(name, 0);
        this.damage = damage;
    }

    public void use(Battler user, Battler target){

        int a = (int) user.getMag();
        int b = (int) user.getStr();

        if(a>b){
            c = a;
        }
        else{
            c = b;
        }


        target.reduceHP((int)(damage * c/target.getEnd()));
        System.out.println(result(user, target));

    }

    public String getInfo(){
        return String.format("%s\nBase Power: %d\n Special Move", getName(), damage);
    }
}