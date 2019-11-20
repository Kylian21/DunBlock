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
    boolean emptyChest = false;

    public ChestBloc(Character character, Point position) {
        super(position);
    }
    
    private Tool randomTool(){
        
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

    public Tool getTool() {
        return randomTool;
    }
    public void clearChest(){
        this.randomTool=null;
    }

    public boolean isEmptyChest() {
        return emptyChest;
    }

    public void setEmptyChest(boolean emptyChest) {
        this.emptyChest = emptyChest;
    }
    
    @Override
    public String toString() {
        return "@";
    }
    
}
