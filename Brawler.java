public class Brawler extends PC {

  public Brawler() {

    super(10, 7, 6, 5, 4, 3, "Brawler", 10);

    addToMovePool(new PhysAttack(1, "Bonk"));
    addToMovePool(new PhysAttack(2, "Fists of Fury"));
    addToMovePool(new Debuff('e', "Taunt", 3));
    addToMovePool(new Buff('s', "Smash!", 3));
    addToMovePool(new SpAttack(1, "Aura Blast", 3));

    System.out.println(getInfo());

  }

}