public class Potion extends Item{

    private char statAffected; //p = mana

    public Potion(String name, char statAffected) {
        super(name);
        this.statAffected = statAffected;
    }

    @Override
    public void use(Battler user, Battler target) {
        
        switch(statAffected){
            case 'h':
                target.addHP(5);
                break;

            case 'p':
                ((PC)(target)).addMP(5);
                break;

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


        System.out.println(result(user, target));
        Main.inventory.remove(this);
    }

    @Override
    public String getInfo() {

        String info = "A " + getName() + "; ";

        switch(statAffected){
            case 'h':
                info += "Heals for 5 hp";
                break;

            case 'p':
                info += "Restores 5 mp";
                break;

            case 's':
                info += "Buffs the user's strength";
                break;

            case 'e':
                info += "Buffs the user's endurance";
                break;

            case 'd':
                info += "Buffs the user's dexterity";
                break;

            case 'w':
                info += "Buffs the user's warding";
                break;

            case 'm': 
                info += "Buffs the user's magic";
                break;
        
        }
        return info;
    
    
    }
}
