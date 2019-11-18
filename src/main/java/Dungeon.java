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
    private Bloc[][] room;

    public Dungeon(int SIZEX, int SIZEY) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;
        this.room = new Bloc [SIZEX][SIZEY];
    }
    
    public void dungeonGenerator(Hero hero){
        for(int i=0;i<SIZEY;i++){
            for(int k=0;k<SIZEX;k++){
                Point position = new Point(k,i);
                this.room[i][k] = blocGenerator(position,hero);
            }
        }
    }
    
    
    public Bloc blocGenerator(Point position,Hero hero){
        double randomNumber = Math.random()*(100);       
        
        if(position.getX()==0 && position.getY()==0){
            Bloc blocWithHero = new Bloc(position);
            blocWithHero.setCharacter(hero);
            return blocWithHero;
        }
        if (randomNumber<=5){//5% chance to have a Trapbloc
            TrapBloc trap = new TrapBloc(position);
            return trap;
        }
        else if(randomNumber<=12){//7% chance to have a ChestBloc
            ChestBloc chest = new ChestBloc(null, position);
            return chest;
        }
        else if(randomNumber<=19){//7% chance to have a monster in a bloc
            Monster monster= new Monster(position, 30,"spider");
            Bloc blocWithMonster = new Bloc(position);
            blocWithMonster.setCharacter(monster);
            return blocWithMonster;
        }
        else if (randomNumber<=39){//20% chance to have a mineralBloc
            MineralBloc mineralBloc = new MineralBloc(position);
            return mineralBloc;
        }
        else{
            Bloc emptyBloc = new Bloc(position);
            return emptyBloc;
        }
    }
    
    
    public void printDungeon(){
        for(int i=0;i<SIZEY;i++){
            if(i==0){
                for(int z=0;z<SIZEX*2+2;z++){
                    System.out.print("-");
                }
                System.out.println();
            }
            
            System.out.print("|");
            for(int k=0;k<SIZEX;k++){
                System.out.print(this.room[k][i]);
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
            if(i==SIZEY-1){
                for(int z=0;z<SIZEX*2+2;z++){
                    System.out.print("-");
                }
            }
        }
    }
    
    public Bloc getBloc(Point position){
        if (position.getX()<0 || position.getX()>=SIZEX || position.getY()<0 || position.getY()>=SIZEY){return null;}
        else return this.room[(int)position.getX()][(int)position.getY()];
    }
    
}
