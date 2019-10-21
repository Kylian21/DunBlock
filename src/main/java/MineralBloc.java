/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class MineralBloc extends InteractiveBloc {
    
    private final Mineral MineralType = randomMineral();
    private boolean blocMined;

    public MineralBloc(Character character, Point position,boolean blocMined) {
        super(35, character, position);
        this.blocMined=blocMined;
    }
    public Mineral randomMineral(){
       double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    @Override
    public String toString() {
        return "*";
    }
    
    
    
    
    
    
    
}
