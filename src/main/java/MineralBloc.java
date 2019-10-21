/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class MineralBloc extends InteractiveBloc {
    Mineral MineralType;

    public MineralBloc(Mineral MineralType, int percentageOfAppearing, Character character, boolean canBeTravel, int generationRate, Point position) {
        super(percentageOfAppearing, character, canBeTravel, generationRate, position);
        this.MineralType = MineralType;
    }
    
    
    
    
}
