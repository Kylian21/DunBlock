/*
 * DunBlock JAVA project
 */

import java.util.Random;

/**
 * This interface is a link between Character & TrapBloc (the classes that deal damages)
 * @author Louis HARISMENDY Kylian SALOMON
 */
public interface Damager {
    /**
     * Set the attack of a character
     * @param characterAttack is the attack table of the character we need to set
     * @param newAttack is his new attack
     */
    abstract void setAttack(int[] characterAttack,int[] newAttack);
    /**
     * Get the attack
     * @see Character
     * @see TrapBloc
     * @return the attack table of the character
     */
    int[] getAttack();
    
    /**
     * how a character is damaging
     * @param charAttacked is the character who is attack
     * @param attackArray the attack table of the attacker
     */
    default void attackaCharacter(Character charAttacked,int[] attackArray){
        Random rand=new Random();
        int rdmAttackHeroIndex=rand.nextInt(6);
        charAttacked.healthPoint-=attackArray[rdmAttackHeroIndex];
        System.out.println(" ATTACK : -"+attackArray[rdmAttackHeroIndex]+" HP");
        System.out.println(charAttacked.name+" HP = "+charAttacked.healthPoint);
    }
}
