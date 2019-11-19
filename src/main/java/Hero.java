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
    private Tool[] Inventory;

    public Hero(Point position,int healthPoint, String name) {
        super(position,healthPoint,name);
        super.setAttack(setHeroAttack());
    }

    
    public void move (Point toPosition){
        super.setPosition(toPosition);
    }
    
    public int[] setHeroAttack(){
        int [] heroAttack = new int[6];
        for(int i=0;i<6;i++){heroAttack[i]=i+2;}
        return heroAttack;
    }
    
    public void printHeroInfo(){
        System.out.println();
        System.out.println(this.name+" HP = "+this.healthPoint+" PV "+"LINGOT : ");
        System.out.println("IRON : "+this.lingots[0]+" GOLD : "+this.lingots[1]+" DIAMOND : "+this.lingots[2]);
    }
    
    public void setLingot(int value, int index){
        this.lingots[index]= value;
    }
    
    @Override
    public String toString() {
        return "H";
    }
    
    
}
