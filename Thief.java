

public class Thief extends PC {

  public Thief() {
    super(10, 6, 4, 8, 4, 5, "Thief", 100);

    addToMovePool(new PhysAttack(1, "Bonk"));
    addToMovePool(new Debuff('s', "Updog", 3));
    addToMovePool(new Healing(2, "Potion", 4));
    addToMovePool(new PhysAttack(3, "Backstab"));
    addToMovePool(new Buff('d', "Fancy Footwork", 3));

    System.out.println(getInfo());
  }

}