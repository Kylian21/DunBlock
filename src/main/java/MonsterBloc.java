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
    
    private final Mineral mineralType = randomMineral();

    public MonsterBloc(int healthPoint, int[] attack, String name, Point position) {
        super(healthPoint, attack, name, position);
    }
    
    public Mineral randomMineral(){
       double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
