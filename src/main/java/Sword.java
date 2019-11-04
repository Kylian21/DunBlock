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
                this.attack[0]=2;
                this.attack[1]=2;
                this.attack[2]=3;
                this.attack[3]=4;
                this.attack[4]=4;
                this.attack[5]=5;
                break;
            case Gold:
                this.attack[0]=3;
                this.attack[1]=3;
                this.attack[2]=4;
                this.attack[3]=4;
                this.attack[4]=5;
                this.attack[5]=5;
                break;
            case Diamond:
                this.attack[0]=3;
                this.attack[1]=3;
                this.attack[2]=4;
                this.attack[3]=5;
                this.attack[4]=6;
                this.attack[5]=6;
                break;  
            default:
                break;
        }
    }
    
    
}
