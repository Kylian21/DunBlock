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
    private final int[] attack = new int[6];

    public TrapBloc(Point position) {
        super(position);
        this.attack[0] = 2;
        this.attack[1] = 2;
        this.attack[2] = 4;
        this.attack[3] = 6;
        this.attack[4] = 6;
        this.attack[5] = 6;
    }
    @Override
    public void dealDamage(int attack, Hero hero){
        hero.healthPoint -= attack;
    }
    @Override
    public String toString() {
        return "=";
    }

    
    
    
    
}
