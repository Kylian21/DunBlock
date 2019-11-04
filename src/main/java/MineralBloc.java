/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class MineralBloc extends Bloc implements LingotDrop{
    
    private final Mineral mineralType;
    private boolean blocMined;

    public MineralBloc(Point position) {
        super(position);
        this.blocMined=true;
        this.mineralType = randomMineral();
    }
    
    public Mineral randomMineral(){
       double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }

    public void setBlocMined(boolean blocMined) {
        this.blocMined = blocMined;
    }
    
    
    @Override
    public String toString() {
        return "*";
    }
    
    
    
    
    
    
    
}
