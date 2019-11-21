/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class TrapBloc extends Bloc implements Damager{
    
    private int [] attack = new int[6];
    private boolean activated = false;

    public TrapBloc(Point position) {
        super(position);
        setAttack(this.attack,null);
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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
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
