/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Character{
    
    Point position;
    int healthPoint​;
    int[] attack​ = new int[6];
    String name ;

    public Character(Point position,int healthPoint,String name) {
        this.position = position;
        this.healthPoint = healthPoint;
        this.name = name;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setAttack(int[] attack) {
        this.attack = attack;
    }
    
    public boolean isAlive(int healthPoint){
        return (healthPoint<0);
    }
}
