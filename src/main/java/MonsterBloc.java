/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY
 */
public class MonsterBloc extends CharacterBloc{
    
    Mineral mineralType;

    public MonsterBloc(int healthPoint, int[] attack, String name, Point position) {
        super(healthPoint, attack, name, position);
    }

    @Override
    public String toString() {
        return "M";
    }
}
