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

    public Hero(Point position,int healthPoint, String name) {
        super(position,healthPoint,name);
        super.setAttack(setHeroAttack());
    }

    
    public void move (Point toPosition){
        super.setPosition(toPosition);
    }
    
    public int[] setHeroAttack(){
        int [] heroAttack = new int[6];
        for(int i=0;i<6;i++){heroAttack[i]=i+2;}
        return heroAttack;
    }
    @Override
    public String toString() {
        return "H";
    }
    
    
}
