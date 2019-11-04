/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class ChestBloc extends Bloc {
    Tool randomTool;

    public ChestBloc(Tool randomTool, Character character, Point position) {
        super(position);
        this.randomTool = randomTool;
    }
    
    
}
