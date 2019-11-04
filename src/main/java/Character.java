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
    int[] attack​;
    String name ;

    public Character(Point position,int healthPoint,String name,int[] attack) {
        this.position = position;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.name = name;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    
    
    public boolean isAlive(int healthPoint){
        return (healthPoint<0);
    }
}
