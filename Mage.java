

public class Mage extends PC {

  public Mage() {
    super(10, 2, 3, 4, 5, 7, "Mage", 10);

    addToMovePool(new PhysAttack(1, "Bonk"));
    addToMovePool(new Debuff('w', "Fake Tears", 3));
    addToMovePool(new SpAttack(2, "Fireball", 3));
    addToMovePool(new SpAttack(4, "Fire Blast", 7));
    addToMovePool(new Buff('m', "Wonderbread", 4));

    System.out.println(getInfo());
  }

}