

public abstract class Move implements GetInfo, Use{

    private String name;
    private int cost;

    Move(String name, int cost){
        this.name = name;
        this.cost = cost;

    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public String toString(){
        return name;
    }

    public String result(Battler user, Battler target){
        return String.format("%s used %s on %s! %s has %d health remaining!", user.getName(), getName(), target.getName(), target.getName(), target.getHp());
    }
}