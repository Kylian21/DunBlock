/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Dungeon {
    private int SIZEX, SIZEY;
    private Block room[][] = new Block[SIZEX][SIZEY];
    
    public void printDungeon(){
        for(int i=0;i<SIZEY;i++){
            for(int k=0;k<SIZEX;k++){
                System.out.println(this.room[k][i]);
            }
        }
    }
}