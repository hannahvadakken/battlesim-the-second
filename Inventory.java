import java.util.LinkedList;

public class Inventory {

    private static LinkedList<Item> inventory;

    public Inventory(){
        inventory = new LinkedList<Item>();
        inventory.add(new Potion("HP Potion", 'h'));
        inventory.add(new Potion("MP Potion", 'p'));
        inventory.add(new Potion("Strength Potion", 's'));
        inventory.add(new Potion("Endurance Potion", 'e'));
        inventory.add(new Potion("Magic Potion", 'm'));

    }

    public String getPrintableInventory(){
        String inventoryString = "[";

        for(int i = 0; i < inventory.size(); i++){
            Item x = inventory.get(i);
            inventoryString += ( "(" + i + ")" + x.getName() + ", ");

        }
        return inventoryString + "]";
    }

    public void remove(Item thing){
        inventory.remove(thing);
    }

    public Item get(int index){
        return inventory.get(index);
    }

    public int size(){
        return inventory.size();
    }
    
}
