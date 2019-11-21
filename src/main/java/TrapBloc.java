/*
 * DunBlock JAVA project
 */

/**
 * Class with parameters of 
 * @author Louis HARISMENDY & Kylian SALOMON
 */

public class TrapBloc extends Bloc implements Damager{
    
    private int [] attack = new int[6];
    private boolean activated = false;

    public TrapBloc(Point position) {
        super(position);
        setAttack(this.attack,null);
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
