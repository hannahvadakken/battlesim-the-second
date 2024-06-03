
import java.util.ArrayList;

public abstract class Battler implements Comparable<Battler>{
  // Fields
  private String name;

  // stats:
  private final int hp, str, end, dex, war, mag;
  private double strMult, endMult, dexMult, warMult, magMult;
  private final String color;
  private final ArrayList<Move> movePool;



  // strength, attack
  // endurance, defense
  // dexterity, speed
  // warding, special def & mana regen
  // magic, special atk

  private int currentHp; 

  // Constructor
  public Battler(int h, int s, int e, int d, int w, int m, String name, String color) {
    this.name = name;

    this.hp = h;
    this.str = s;
    this.end = e;
    this.dex = d;
    this.war = w;
    this.mag = m;
    
    this.color = color;

    currentHp = h;

    strMult = endMult = dexMult = warMult = magMult = 1;

    this.movePool = new ArrayList<Move>(5);

    Main.turnOrder.add(this);

  }

  // getters

  public String getName() {
    return color + name + Colors.reset;
  }

  public int getHp() {
    return currentHp;
  }

  public double getStr() {
    return str * strMult;
  }

  public double getEnd() {
    return end * endMult;
  }

  public double getDex() {
    return dex * dexMult;
  }

  public double getWar() {
    return war * warMult;
  }

  public double getMag() {
    return mag * magMult;
  }

  // debuffs

  public void dexDebuff() {
    dexMult = Math.max(0.25, dexMult * 0.5);
  }

  public void strDebuff() {
    strMult = Math.max(0.25, strMult * 0.5);
  }

  public void endDebuff() {
    endMult = Math.max(0.25, endMult * 0.5);
  }

  public void warDebuff() {
    warMult = Math.max(0.25, warMult * 0.5);
  }

  public void magDebuff() {
    magMult = Math.max(0.25, magMult * 0.5);
  }

  // buffs

  public void strBuff() {
    strMult = Math.min(2.25, strMult * 1.5);
  }

  public void endBuff() {
    endMult = Math.min(2.25, endMult * 1.5);
  }

  public void dexBuff() {
    dexMult = Math.min(2.25, dexMult * 1.5);
  }

  public void warBuff() {
    warMult = Math.min(2.25, warMult * 1.5);
  }

  public void magBuff() {
    magMult = Math.min(2.25, magMult * 1.5);
  }

  // take damage

  public void reduceHP(int damage) {
    currentHp -= damage;
    
    if(currentHp < 0) currentHp = 0;

    if(this instanceof PC) Music.sound("./audiofiles/hurt.wav");

  }

  // heal

  public void addHP(int healing) {
    currentHp += healing;

    if(currentHp > hp) currentHp = hp;

    if(this instanceof PC) Music.sound("./audiofiles/heal.wav");
  }

  public void addToMovePool(Move newMove){
    movePool.add(newMove);
  }

  public Move getMove(int moveNum){
    return movePool.get(moveNum);
  }

  public String getPrintableMovePool(){

    String x = "";

    for(int i = 0; i < movePool.size(); i++){
      x += String.format("(%d)%s, ", i, movePool.get(i).getName());
      
    }
    return x;
  }

  public String getPrintableStats(){

    return String.format("HP: %d, STR: %.1f, END: %.1f, DEX: %.1f, WAR: %.1f, MAG: %.1f", getHp(), getStr(), getEnd(), getDex(), getWar(), getMag());
  }

  public int compareTo(Battler other){

    Battler o = (Battler) other;

    if(o.getDex() > getDex()){
      return 1;
    }

    if (getDex() > o.getDex()){
      return -1;
    }

    return 0;

  }

  public ArrayList<Move> getMovePool(){
    return movePool;
  }

  public abstract void yourTurn();

}