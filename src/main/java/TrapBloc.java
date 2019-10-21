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
    int attack[];

    public TrapBloc(int[] attack, int percentageOfAppearing, Character character, boolean canBeTravel, int generationRate, Point position) {
        super(percentageOfAppearing, character, canBeTravel, generationRate, position);
        this.attack = attack;
    }
    
    
    
}
