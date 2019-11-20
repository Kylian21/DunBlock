
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
    abstract void setAttack(int[] characterAttack,int[] newAttack);
    
    abstract int[] getAttack();
    
    default void attackaCharacter(Character charAttacked,int[] attackArray){
        Random rand=new Random();
        int rdmAttackHeroIndex=rand.nextInt(6);
        charAttacked.healthPoint-=attackArray[rdmAttackHeroIndex];
        System.out.println(" ATTACK : -"+attackArray[rdmAttackHeroIndex]+" HP");
        System.out.println(charAttacked.name+" HP = "+charAttacked.healthPoint);
    }
}
