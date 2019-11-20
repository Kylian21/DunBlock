import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Hero extends Character{
    
    private int[] lingots = new int[3];
    private List<Tool> item;

    public Hero(Point position,int healthPoint, String name) {
        super(position,name,healthPoint);
    }

    
    public void move (Point toPosition){
        super.setPosition(toPosition);
    }
    
    @Override
    public void setAttack(int[] attacktmp){
        for(int i=0;i<attacktmp.length;i++){Hero.attack[i]=attacktmp[i]+2;}
    }
    
    public void printHeroInfo(){
        System.out.println();
        System.out.println(this.name+" HP = "+this.healthPoint+" PV "+"LINGOT : ");
        System.out.println("IRON : "+this.lingots[0]+" GOLD : "+this.lingots[1]+" DIAMOND : "+this.lingots[2]);
    }
    
    public void setLingot(int value, int index){
        this.lingots[index]= value;
    }
    public void setTool(Tool item){
        this.item.add(item);
    }
    @Override
    public String toString() {
        return "H";
    }
}
