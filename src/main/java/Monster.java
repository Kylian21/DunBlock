/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY
 */
public class Monster extends Character{
    
    private final Mineral mineralType = randomMineral();

    public Monster(Point position,int healthPoint, String name,int[] attack) {
        super(position,healthPoint,name,attack);
        
    }

    
    public Mineral randomMineral(){
       double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
