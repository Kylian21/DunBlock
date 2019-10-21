/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class EmptyBlock extends Block{
    Character character = new Character();

    public EmptyBlock(boolean canBeTravel, int generationRate) {
        super(canBeTravel, generationRate);
    }

    
    
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    
}
