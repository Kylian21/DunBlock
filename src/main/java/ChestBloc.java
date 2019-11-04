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
    Tool randomTool = randomTool();

    public ChestBloc(Character character, Point position) {
        super(position);
    }
    
    public Tool randomTool(){
        
        double _randomNumber = Math.random()*(100);
        if(_randomNumber<=50){
            Sword sword = new Sword();
            return sword;
        } 
        else{
            PickAxe pickaxe = new PickAxe();
            return pickaxe;
        }
    }
    
    @Override
    public String toString() {
        return "@";
    }
    
}
