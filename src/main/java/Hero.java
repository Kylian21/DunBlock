/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Hero extends Character{
    
    private int lingots;
    private Tool[] Inventory;

    public Hero(Point position,int healthPoint, int[] attack, String name) {
        super(position,healthPoint,name,attack);
    }

    
    void move (Point toPosition){
        super.setPosition(toPosition);
    }

    @Override
    public String toString() {
        return "H";
    }
    
    
}
