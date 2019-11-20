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
    
    public Monster(Point position,String name,int healtPoint) {
        super(position,name,healtPoint);
        super.setAttack(setMonsterAttack());
    }    
    
    public int[] setMonsterAttack(){
        int[] monsterAttackPoint = new int[6];
        for(int i=0;i<6;i++){monsterAttackPoint[i]=i+1;}
        return monsterAttackPoint;
    }
    
    @Override
    public void dealDamage(int attack, Hero hero){
        hero.healthPoint -= attack;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
