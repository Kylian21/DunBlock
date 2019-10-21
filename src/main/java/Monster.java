/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY
 */
public class Monster extends CharacterBloc{

    public Monster(int healthPoint, int[] attack, String name, Point position) {
        super(healthPoint, attack, name, position);
    }
    
    Mineral mineralType;
}
