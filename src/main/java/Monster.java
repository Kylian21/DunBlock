/*
 * DunBlock JAVA project
 */

/**
 * This class contains the methods and parameters of a Monster
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Monster extends Character implements LingotDrop{
    
    private final Mineral mineralType = randomMineral();
    
    /**
     * The constructor
     * @see Point
     * @param position of the monster
     * @param name of the monster
     * @param healthPoint of the monster
     * @param attackFromTXT attack table readed from txt
     */
    public Monster(Point position, String name,int healthPoint,int [] attackFromTXT){
        super(position,name,healthPoint);
        setAttack(super.attack,attackFromTXT);
    }    
    
    @Override
    public final void setAttack(int[] characterAttack,int[] newAttack){
        System.arraycopy(newAttack, 0, super.attack, 0, characterAttack.length);
    }

    public Mineral getMineralType() {
        return mineralType;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
