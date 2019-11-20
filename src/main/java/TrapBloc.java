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

    public TrapBloc(Point position) {
        super(position);
    }
    
    @Override
    public String toString() {
        return "=";
    }

    @Override
    public void setAttack(int[] attack) {
        TrapBloc.attack[0] = 2;
        TrapBloc.attack[1] = 2;
        TrapBloc.attack[2] = 4;
        TrapBloc.attack[3] = 6;
        TrapBloc.attack[4] = 6;
        TrapBloc.attack[5] = 6;
    }
    
}
