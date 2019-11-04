/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY
 */
public class Monster extends Character implements Damager,LingotDrop{
    
    private final Mineral mineralType = randomMineral();
    
    public Monster(Point position,int healthPoint, String name) {
        super(position,healthPoint,name);
        super.setAttack(setMonsterAttack());
    }

    
    public Mineral randomMineral(){
       double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    
    
    public int[] setMonsterAttack(){
        int[] monsterAttackPoint = new int[6];
        for(int i=0;i<6;i++){monsterAttackPoint[i]=i+1;}
        return monsterAttackPoint;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
