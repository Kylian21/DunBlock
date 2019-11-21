/*
 * DunBlock JAVA project
 */

/**
 * This is one of the different bloc and it inflict damage to
 *  the hero.It is hidden on the map until the Hero walk through.
 * @author Louis HARISMENDY & Kylian SALOMON
 */

public class TrapBloc extends Bloc implements Damager{
    
    private final int [] attack = new int[6];
    private boolean activated;
    /**
     * Construct the TrapBloc and set it attack and hide it
     *  by set the variable activated false.
     * @param position the position of the TrapBloc.
     */
    public TrapBloc(Point position) {
        super(position);
        this.activated = false;
        setAttack(this.attack,null);
    }
    /**
     * 
     * @return true if the true if the Hero walk through
     */
    public boolean isActivated() {
        return activated;
    }
    /**
     * 
     *Set true when the Hero walk through
     */
    public void setActivated() {
        this.activated = true;
    }
    
    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
    @Override
    public final void setAttack(int[] characterAttack,int[] newAttack) {
        attack[0] = 2;
        attack[1] = 2;
        attack[2] = 4;
        attack[3] = 6;
        attack[4] = 6;
        attack[5] = 6;
    }

    @Override
    public int[] getAttack() {
        return this.attack;
    }
    
    
    @Override
    public String toString() {
        if(super.getCharacter() instanceof Hero){
            return "H";
        }
        else if(activated){
            return "=";
        }
        else{
            return " ";
        }
    }
}
