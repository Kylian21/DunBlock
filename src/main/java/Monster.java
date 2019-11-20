/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY
 */
public class Monster extends Character implements LingotDrop{
    
    private final Mineral mineralType = randomMineral();
    public Monster(Point position, String name,int healthPoint,int [] attackFromTXT){
        super(position,name,healthPoint);
        setAttack(super.attack,attackFromTXT);
    }    
    
    @Override
    public final void setAttack(int[] characterAttack,int[] newAttack){
        System.arraycopy(newAttack, 0, super.attack, 0, characterAttack.length);
    }

    public Mineral getMineralType() {
        return mineralType;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
