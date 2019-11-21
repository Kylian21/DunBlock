/*
 * DunBlock JAVA project
 */

/**
 * The pickAxe is a tool which can be hold by the Hero and only be
 *  found in chest. Each pickAxe have a mineral Type and give a bonus
 *  to the hero when he destroy a MineralBloc.
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class PickAxe extends Tool{
    
    private int pickAxeAdvantage;
    /**
     * Construct the PickAxe by giving it a mineral type and call
     * set the advantage of the pickAxe.
     * @see PickAxe#pickAxeAdvantage
     */
    public PickAxe() {
        switch(super.getMineralType()){
            case Iron: 
                setPickAxeAdvantage(1);
                break;
            case Gold: 
                setPickAxeAdvantage(3);
                break;
            case Diamond: 
                setPickAxeAdvantage(5);
                break;
            default:
                break;
        }
    }
    /**
     * Set a advantage whiwh depend of the mineral type of 
     * the pickAxe.
     * @param pickAxeAdvantage 
     */
    private void setPickAxeAdvantage(int pickAxeAdvantage) {
        this.pickAxeAdvantage = pickAxeAdvantage;
    }
    /**
     * 
     * @return the pickAxeAdvantage.
     */
    public int getPickAxeAdvantage() {
        return pickAxeAdvantage;
    } 
    
    @Override
    public String toString() {
        return super.getMineralType()+" PickAxe";
    }
}
