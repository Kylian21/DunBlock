/*
 * DunBlock JAVA project
 */

/**
 * This class contains the parameters of a character
 * @author Louis HARISMENDY Kylian SALOMON
 */
public abstract class Character implements Damager{
    
    private Point position;
    protected int[] attack = new int[6];
    protected int healthPoint​;
    protected String name ;

    /**
     * The constructor
     * @see Point
     * @param position of the Character
     * @param name of the Character
     * @param healthPoint of the Character
     */
    public Character(Point position,String name,int healthPoint) {
        this.position = position;
        this.healthPoint = healthPoint;
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }
    
    @Override
    public abstract void setAttack(int[] characterAttack,int[] newAttack);
    
    /**
     * Set the Position
     * @see Point
     * @param position 
     */
    public void setPosition(Point position) {
        this.position = position;
    }
    
    /**
     * Test if the character is Alive
     * @return true if the character is Alive (false if not)
     */
    public boolean isAlive(){
        return (this.healthPoint>0);
    }
    
    /**
     * @see Damager
     * 
     */
    @Override
    public int[] getAttack(){
        return this.attack;
    }
}
