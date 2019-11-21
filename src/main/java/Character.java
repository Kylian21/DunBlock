/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public abstract class Character implements Damager{
    
    private Point position;
    protected int[] attack = new int[6];
    protected int healthPoint​;
    protected String name ;

    public Character(Point position,String name,int healthPoint) {
        this.position = position;
        this.healthPoint = healthPoint;
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }
    
    @Override
    public abstract void setAttack(int[] characterAttack,int[] newAttack);
    
    public void setPosition(Point position) {
        this.position = position;
    }
    
    public boolean isAlive(int healthPoint){
        return (healthPoint<0);
    }
    
    @Override
    public int[] getAttack(){
        return this.attack;
    }
}
