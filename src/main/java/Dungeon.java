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
    private int monsterNumber =0;

    public Dungeon(int SIZEX, int SIZEY) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;
        this.room = new Bloc [SIZEX][SIZEY];
    }
    
    public void dungeonGenerator(Hero hero){
        for(int y=0;y<SIZEY;y++){
            for(int x=0;x<SIZEX;x++){
                Point position = new Point(x,y);
                this.room[y][x] = blocGenerator(position,hero);
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
            String[] monsters = null;
            try{
                monsters = ReadTextAsString.readFileAsString().split(System.getProperty("line.separator"));
            }
            catch(Exception e){
                System.out.println(e);
            }
            String[] monsterElement = monsters[0].split(",");
            Monster monster= new Monster(position, monsterElement[0],Integer.parseInt(monsterElement[1]));
            //set attack code
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
        for(int y=0;y<SIZEY;y++){
            if(y==0){
                for(int i=0;i<SIZEX*2+2;i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            
            System.out.print("|");
            for(int x=0;x<SIZEX;x++){
                System.out.print(this.room[y][x]);
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
            if(y==SIZEY-1){
                for(int z=0;z<SIZEX*2+2;z++){
                    System.out.print("-");
                }
            }
        }
    }
    
    public Bloc getBloc(Point position){
        if (position.getX()<0 || position.getX()>=SIZEX || position.getY()<0 || position.getY()>=SIZEY){return null;}
        else return this.room[(int)position.getY()][(int)position.getX()];
    }
    
}
