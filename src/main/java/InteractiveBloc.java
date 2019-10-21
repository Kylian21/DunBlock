/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class InteractiveBloc extends Bloc {
    int percentageOfAppearing;
    Character character;

    public InteractiveBloc(int percentageOfAppearing, Character character, boolean canBeTravel, int generationRate, Point position) {
        super(canBeTravel, generationRate, position);
        this.percentageOfAppearing = percentageOfAppearing;
        this.character = character;
    }
    
    
}
