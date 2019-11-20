
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public interface Damager {
    static int[] attack = new int[6];
    abstract void setAttack(int[] attack);
    
    default int[] getAttack(){
        return Damager.attack;
    }
    
    default void attackaCharacter(Character charAttack,int[] attackArray){
        Random rand=new Random();
        int rdmAttackHeroIndex=rand.nextInt(6);
        charAttack.healthPoint-=attackArray[rdmAttackHeroIndex];
        System.out.println(" ATTACK : -"+attackArray[rdmAttackHeroIndex]);
        System.out.println(charAttack.name+"HP ="+charAttack.healthPoint);
    }
}
