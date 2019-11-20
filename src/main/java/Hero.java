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
    private final Tool[] item =new Tool[2];

    public Hero(Point position,int healthPoint, String name) {
        super(position,name,healthPoint);
        setAttack(super.attack,null);
    }

    
    public void move (Point toPosition){
        super.setPosition(toPosition);
    }
    
    @Override
    public final void setAttack(int[] characterAttack,int[] newAttack){
        if(newAttack != null){
            System.arraycopy(newAttack, 0, characterAttack, 0, characterAttack.length);
        }
        else for(int i=0;i<characterAttack.length;i++){characterAttack[i]=i+2;}
    }
    
    public void printHeroInfo(){
        System.out.println();
        System.out.println(this.name+" HP = "+this.healthPoint+" PV ");
        System.out.println("IRON : "+this.lingots[0]+"  GOLD : "+this.lingots[1]+"  DIAMOND : "+this.lingots[2]);
        
    }
    
    public void printInventory(){
        if(item[0]==null && item[1]==null){System.out.println("Your inventory is empty. Found chests !");}
        else for(int i=0;i<item.length;i++){
            if(item[i]!=null){
                System.out.println(item[i]+" / ");
                if(i==0) System.out.println(Arrays.toString(super.attack));
            }
        }
    }
    
    public void addLingot(int value, int index){
        this.lingots[index]+=value;
    }
    
    public void setTool(Tool item){
        if(item instanceof Sword){ 
            setAttack(this.attack,((Sword)item).getAttack());
            this.item[0]=item;
        }
        else this.item[1]=item;;
    }

    public Tool getItem(int index) {
        return item[index];
    }
    

    @Override
    public String toString() {
        return "H";
    }
}
