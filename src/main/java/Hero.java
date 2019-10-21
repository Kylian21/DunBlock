/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Hero extends CharacterBloc{

    public Hero(int lingots, tool[] Inventory, int healthPoint, int[] attack, String name, Point position) {
        super(healthPoint, attack, name, position);
        this.lingots = lingots;
        this.Inventory = Inventory;
    }
    
    int lingots;
    tool[] Inventory;
    
    void move (Point toPosition){
        super.setPosition(toPosition);
    }
}
