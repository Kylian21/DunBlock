/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class HeroBloc extends CharacterBloc{
    
    int lingots;
    Tool[] Inventory;

    public HeroBloc(int lingots, Tool[] Inventory, int healthPoint, int[] attack, String name, Point position) {
        super(healthPoint, attack, name, position);
        this.lingots = lingots;
        this.Inventory = Inventory;
    }
    
    void move (Point toPosition){
        super.setPosition(toPosition);
    }

    @Override
    public String toString() {
        return "H";
    }
    
    
}
