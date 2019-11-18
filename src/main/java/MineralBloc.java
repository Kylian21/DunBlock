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
    
    private final Mineral mineralType = randomMineral();
    private boolean blocMined;

    public MineralBloc(Point position) {
        super(position);
        this.blocMined=true;
    }
 
    public void setBlocMined(boolean blocMined) {
        this.blocMined = blocMined;
    }
    
    @Override
    public String toString() {
        return "*";
    }
    
    
    
    
    
    
    
}
