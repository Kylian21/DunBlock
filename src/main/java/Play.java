/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Play {
    public static void main(String[] args){
        boolean FLAG = false;
        Dungeon donjon = new Dungeon(5,5);
        Point position = new Point(0,0);
        final Hero hero = new Hero(position, 30, "Garry");
        donjon.dungeonGenerator(hero);
        

        while(!FLAG){
            System.out.println("Hello"+hero.name);
            donjon.printDungeon();
            System.out.println();
            
        }
        
        
  }
    public String[] possibilities(Hero hero, Dungeon donjon){
        String [] choiceList = new String[4];
        Point positionUp = new Point(hero.position.getX(),hero.position.getY()-1);
        Point positionDown = new Point(hero.position.getX(),hero.position.getY()+1);
        Point positionLeft = new Point(hero.position.getX()-1,hero.position.getY());
        Point posiPointRight = new Point(hero.position.getX()+1,hero.position.getY());
        
        for(int i=0;i<4;i++){
            
        }
    }
}
