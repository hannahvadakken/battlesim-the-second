public abstract class Item implements Use, GetInfo{

    private String name;
    
    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String result(Battler user, Battler target){
        return user.getName() + " used " + name + " on " + target.getName() + "!";
    }


    

    
}
