/*
 * DunBlock JAVA project
 */

import java.util.*;

/**
 * This class contains the methods and parameters of the hero
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Hero extends Character{
    
    private int[] lingots = new int[3];
    private final Tool[] item =new Tool[2];
    
    /**
     * The constructor
     * @param position of the Hero
     * @param healthPoint of the Hero
     * @param name of the Hero
     */
    public Hero(Point position,int healthPoint, String name) {
        super(position,name,healthPoint);
        setAttack(super.attack,null);//We set his attack when we create the hero
    }

    /**
     * Move the Hero
     * @param toPosition the position where he is moving
     */
    public void move (Point toPosition){
        super.setPosition(toPosition);
    }
    
    /**
     * To print on the console the hero Info
     */
    public void printHeroInfo(){
        System.out.println();
        System.out.println(this.name+" HP = "+this.healthPoint+" PV ");
        System.out.println("IRON : "+this.lingots[0]+"  GOLD : "+this.lingots[1]+"  DIAMOND : "+this.lingots[2]);
        
    }
    
    /**
     * To print on the console the hero Inventory
     */
    public void printInventory(){
        if(item[0]==null && item[1]==null){System.out.println("Your inventory is empty. Found chests !");}
        else for(int i=0;i<item.length;i++){
            if(item[i]!=null){
                System.out.println(item[i]+" / ");
                if(i==0) System.out.println(Arrays.toString(super.attack));
            }
        }
    }
    
    /**
     * Add Lingots dropped to the hero lingots
     * @param value the number of lingot added
     * @param index the index to sort the lingot by their MineralType
     */
    public void addLingot(int value, int index){
        this.lingots[index]+=value;
    }
    
    /**
     * Add the tool to the inventory, replace if already exist
     * @see Tool
     * @param item the item to add
     */
    public void setTool(Tool item){
        if(item instanceof Sword){ 
            setAttack(this.attack,((Sword)item).getAttack());
            this.item[0]=item;
        }
        else this.item[1]=item;;
    }

    /**
     * to return an item in the inventory
     * @param index index of the item in the inventory (0 for sword, 1 for pick axe)
     * @return the item
     */
    public Tool getItem(int index) {
        return item[index];
    }
    
    @Override
    public final void setAttack(int[] characterAttack,int[] newAttack){
        if(newAttack != null){
            System.arraycopy(newAttack, 0, characterAttack, 0, characterAttack.length);
        }
        else for(int i=0;i<characterAttack.length;i++){characterAttack[i]=i+2;}
    }

    @Override
    public String toString() {
        return "H";
    }
}
