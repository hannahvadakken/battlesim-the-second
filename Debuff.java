

public class Debuff extends Move{

    private char a;
    private String statName;
    
    public Debuff(char a, String name, int cost){

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

    public Debuff(char a, String name){

        this(a, name, 0);
    }



    public void use(Battler user, Battler target){

        switch (a) {
            //int s, int e, int d, int w, int m, String name

            case 's':
                target.strDebuff();
                break;

            case 'e':
                target.endDebuff();
                break;

            case 'd':
                target.dexDebuff();
                break;

            case 'w':
                target.warDebuff();
                break;

            case 'm':
                target.magDebuff();
                break;

            }
            
        if(user instanceof PC){
                ((PC)user).reduceMP(getCost());
            }
            
        System.out.println(result(user, target));
        Music.sound("./audiofiles/useless.wav");

    }

    public String getInfo(){
        return String.format("%s\n%s Stat Decrease, MP Cost:%d\n", getName(), statName, getCost());
    }

    public String result(Battler user, Battler target){
        return String.format("%s used %s on %s! %s's stats have been reduced!", user.getName(), getName(), target.getName(), target.getName());
    }

}