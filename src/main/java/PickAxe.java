/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class PickAxe extends Tool{
    
    private int pickAxeAdvantage;

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

    private void setPickAxeAdvantage(int pickAxeAdvantage) {
        this.pickAxeAdvantage = pickAxeAdvantage;
    }

    public int getPickAxeAdvantage() {
        return pickAxeAdvantage;
    } 
    
    @Override
    public String toString() {
        return super.getMineralType()+" PickAxe";
    }
}
