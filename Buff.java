
public class Buff extends Move{

    private char a;
    private String statName;
    
    public Buff(char a, String name, int cost){

        super(name, cost);
        this.a = a;

        switch(a){

            case 's':
                statName = "STR";
                break;
            case 'e':
                statName = "END";
                break;
            case 'd':
                statName = "DEX";
                break;
            case 'w':
                statName = "WAR";
                break;
            case 'm':
                statName = "MAG";
                break;

        }
    }

    public void use(Battler user, Battler target){

      switch (a) {
        //int s, int e, int d, int w, int m, String name

        case 's':
            target.strBuff();
            break;

        case 'e':
            target.endBuff();
            break;

        case 'd':
            target.dexBuff();
            break;

        case 'w':
            target.warBuff();
            break;

        case 'm':
            target.magBuff();
            break;

    }
    
    if(user instanceof PC){
        ((PC)user).reduceMP(getCost());
    }

    System.out.println(result(user, target));
    Music.sound("./audiofiles/Point.wav");

    }

    public String getInfo(){
        return String.format("%s\n%s Increase, MP Cost:%d\n", getName(), statName, getCost());
    }

    public String result(Battler user, Battler target){
        return String.format("%s used %s on %s! %s's stats have been increased!", user.getName(), getName(), target.getName(), target.getName());
    }

}