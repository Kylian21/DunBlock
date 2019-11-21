/*
 * DunBlock JAVA project
 */

/**
 *This class is a daugther of the bloc class.It create a chest on the map
 * that the player can open. He will found inside a Sword or a pickaxe. A chest
 * can contain only one tool.
 * @see Bloc
 * @author Louis HARISMENDY & Kylian SALOMON
 */

public class ChestBloc extends Bloc {
    private Tool tool = randomTool();
    private boolean emptyChest = false;

    /**
     * @see Point
     * @param position of the ChestBloc 
     */
    public ChestBloc(Point position) {
        super(position);
    }
    
    /**
     * Return a tool for the chest. Either a Sword, either a pickaxe with
     * 50% chance for each.
     * @see Tool
     * @see Sword
     * @see PickAxe
     * @return a sword or a pickAxe
     */
    private Tool randomTool(){
        
        double _randomNumber = Math.random()*(100);
        if(_randomNumber<=50){
            Sword sword = new Sword();
            return sword;
        } 
        else{
            PickAxe pickaxe = new PickAxe();
            return pickaxe;
        }
    }
    /**
     * @see Tool
     * @return the tool inside the chest
     */
    public Tool getTool() {
        return this.tool;
    }
    /**
     * Clear the chest after the hero get the tool.
     * @see Tool
     */
    public void clearChest(){
        this.tool=null;
    }
    /**
     * 
     * @return true if the chest have no tool.
     */
    public boolean isEmptyChest() {
        return emptyChest;
    }
    /**
     * Set the chest empty.
     */
    public void setEmptyChest() {
        this.emptyChest = true;
    }
    
    @Override
    public String toString() {
        return "@";
    }
    
}
