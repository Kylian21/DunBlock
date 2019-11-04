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
    private Bloc[][] room = new Bloc[SIZEY][SIZEX];
    

    public Dungeon(int SIZEX, int SIZEY) {
        this.SIZEX = SIZEX;
        this.SIZEY = SIZEY;
        dungeonGenerator();
    }
    public void dungeonGenerator(){
        for(int i=0;i<SIZEY;i++){
            for(int k=0;k<SIZEX;k++){
                Point position = new Point();
                position.setX(k);
                position.setY(i);
                this.room[i][k] = blocGenerator(position);
            }
        }
    }
    
    
    public Bloc blocGenerator(Point position){
        double randomNumber = Math.random()*(100);       
                
        if (randomNumber<=5){//5% chance to have a Trapbloc
            TrapBloc trap = new TrapBloc(position);
            return trap;
        }
        else if(randomNumber<=12){//7% chance to have a ChestBloc
            ChestBloc chest = new ChestBloc(randomTool(), null, position);
            return chest;
        }
        else if(randomNumber<=19){//7% chance to have a monster in a bloc
            Monster monster= new Monster(position, 30,"spider",setMonsterAttack());
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
    
    public Tool randomTool(){
        
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
    
    public void printDungeon(){
        for(int i=0;i<SIZEY;i++){
            for(int k=0;k<SIZEX;k++){
                System.out.println(this.room[k][i]);
            }
        }
    }
    
    public int[] setMonsterAttack(){
        int[] monsterAttackPoint = new int[6];
        monsterAttackPoint[0] = 1;
        monsterAttackPoint[1] = 2;
        monsterAttackPoint[2] = 3;
        monsterAttackPoint[3] = 4;
        monsterAttackPoint[4] = 5;
        monsterAttackPoint[5] = 6;
        return monsterAttackPoint;
    }
}
