/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class CharacterBloc extends Bloc{
    
    int healthPoint​;
    int[] attack​;
    String name ;

    public CharacterBloc(int healthPoint, int[] attack, String name, Point position) {
        super(position);
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.name = name;
    }
    
    public boolean isAlive(int healthPoint){
        return (healthPoint<0);
    }
}
