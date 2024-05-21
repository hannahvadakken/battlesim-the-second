
public class Cleric extends PC {

  public Cleric() {
    super(10, 3, 5, 3, 7, 6, "Cleric", 10);

    addToMovePool(new PhysAttack(1, "Bonk"));
    addToMovePool(new SpAttack(2, "Fireball", 2));
    addToMovePool(new Healing(2, "Healing Light", 2));
    addToMovePool(new Healing(4, "Everlight", 6));
    addToMovePool(new Buff('w', "Choir Chant", 4));

    System.out.println(getInfo());
    
  }

}