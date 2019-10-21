/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Character {
    int healthPoint​;
    int[] attack​;
    boolean canMove​;
    String name ;
    
    boolean isAlive(int healthPoint)​{
        return healthPoint>0;
    }

    
}
