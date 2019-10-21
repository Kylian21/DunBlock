/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class TrapBloc extends InteractiveBloc {
    private final int attack[];

    public TrapBloc(int[] attack, Character character, Point position) {
        super(5, character, position);
        this.attack = attack;
    }

    @Override
    public String toString() {
        return " ";
    }

    
    
    
    
}
