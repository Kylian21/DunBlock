/*
 * DunBlock JAVA project
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class MineralBloc extends Bloc implements LingotDrop{
    
    private final Mineral mineralType = randomMineral();
    private boolean blocMined;
    /**
     * Construct the MineralBloc
     * @param position The position of the Bloc
     * @see Point
     */
    public MineralBloc(Point position) {
        super(position);
        this.blocMined=false;
    }
    /**
     * Set the bloc mined true when the Hero destroy it
     */
    public void setBlocMined() {
        this.blocMined = true;
    }
    /**
     * 
     * @return the mineral type of the MineralBloc
     * @see Mineral
     */
    public Mineral getMineralType() {
        return mineralType;
    }
    /**
     * 
     * @return true if the bloc is mined.
     */
    public boolean isBlocMined() {
        return blocMined;
    }
    
    @Override
    public String toString() {
        if(super.getCharacter() instanceof Hero){return "H";}
        if(this.blocMined){return " ";}
        else return "*";
        
    }

    
    
    
    
    
    
    
    
}
