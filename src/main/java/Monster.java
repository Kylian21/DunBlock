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
    
        super(position,name,healtPoint);
    }    
    
    @Override
    public void setAttack(int[] attacktmp){
         for(int i=0;i<attacktmp.length;i++){Monster.attack[i]=attacktmp[i];}
    }
    
    @Override
    public String toString() {
        return "M";
    }
}
