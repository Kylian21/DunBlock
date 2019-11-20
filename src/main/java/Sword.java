/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Sword extends Tool{
    private final int[] attack = new int[6];

    public Sword() {
        
        switch(super.getMineralType()){
            case Iron:
                this.attack[0]=4;
                this.attack[1]=5;
                this.attack[2]=5;
                this.attack[3]=6;
                this.attack[4]=6;
                this.attack[5]=7;
                break;
            case Gold:
                this.attack[0]=4;
                this.attack[1]=4;
                this.attack[2]=5;
                this.attack[3]=6;
                this.attack[4]=7;
                this.attack[5]=7;
                break;
            case Diamond:
                this.attack[0]=5;
                this.attack[1]=6;
                this.attack[2]=7;
                this.attack[3]=7;
                this.attack[4]=8;
                this.attack[5]=10;
                break;  
            default:
                break;
        }
    }

    public int[] getAttack() {
        return attack;
    }
    
    @Override
    public String toString() {
        return super.getMineralType()+" Sword";
    }
}
