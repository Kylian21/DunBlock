/*
 * DunBlock JAVA project
 */

/**
 *This is the dungeon which will be display on terminal. It is construct
 * with bloc and generate bloc. The dungeon have a size, it is square, each bloc of the Dungeon 
 * can be a Chestbloc, MineralBloc, TrapBloc or a bloc with inside a monster or the hero.
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Dungeon {
    private final int SIZE;
    private final Bloc[][] room;
    private int monsterNumber =0;
    
    /**
     * @see Bloc
     * Construct the Dungeon and create the room
     * @param SIZE size of the dungeon
     */
    public Dungeon(int SIZE) {
        this.SIZE = SIZE;
        this.room = new Bloc [SIZE][SIZE];
    }
    /**
     * Create a unique point for each bloc and generate a bloc.
     * @see Dungeon#blocGenerator(Point, Hero) 
     * @see Point
     * @see Hero
     * @param hero the hero of the game
     */
    public void dungeonGenerator(Hero hero){
        for(int y=0;y<SIZE;y++){
            for(int x=0;x<SIZE;x++){
                Point position = new Point(x,y);
                this.room[y][x] = blocGenerator(position,hero);
            }
        }
    }
    
    /**
     * Generate a bloc with 5% chance to be a TrapBloc, 7% chance to be a ChestBloc
     *  7% chance to be a bloc with a monster inside, 20% chance to be a 
     *  MineralBloc. It create a random number and then create the correspondant bloc.
     * @param position the position of the bloc
     * @param hero the hero of the Dungeon
     * @return the bloc choosen randomly
     * @see Point
     * @see Hero
     * @see Bloc
     * @see Point#getX() 
     * @see Point#getY()
     * @see Bloc#setCharacter(Character)
     * @see TrapBloc
     * @see ChestBloc
     * @see Monster
     * @see ReadTextAsString
     * @see MineralBloc
     */
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
            ChestBloc chest = new ChestBloc(position);
            return chest;
        }
        else if(randomNumber<=19){//7% chance to have a monster in a bloc
            String[] monsters = null;
            int[] tmpAttack = new int[6];
            try{
                monsters = ReadTextAsString.readFileAsString().split("\n");
            }
            catch(Exception e){
                System.out.println(e);
            }
            //We separate the different monsters and add them in the dungeon
            String[] monsterElement = monsters[monsterNumber%4].split(";");
            for(int i=0;i<tmpAttack.length;i++){
                String [] tmp = monsterElement[2].split(",");
                tmpAttack[i]= Integer.parseInt(tmp[i]);
            }
            Monster monster= new Monster(position, monsterElement[0],Integer.parseInt(monsterElement[1]),tmpAttack);
            monsterNumber++;
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
    
    /**
     * Display the dungeon
     */
    public void printDungeon(){
        for(int y=0;y<SIZE;y++){
            if(y==0){
                for(int i=0;i<SIZE*2+2;i++){
                    System.out.print("-");
                }
                System.out.println();
            }
            
            System.out.print("|");
            for(int x=0;x<SIZE;x++){
                System.out.print(this.room[y][x]);
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.println();
            if(y==SIZE-1){
                for(int z=0;z<SIZE*2+2;z++){
                    System.out.print("-");
                }
            }
        }
    }
    
    /**
     * Return the Bloc with the given position.
     * @param position The position of the Bloc
     * @return The bloc correspondant to the position
     */
    public Bloc getBloc(Point position){
        if (position.getX()<0 || position.getX()>=SIZE || position.getY()<0 || position.getY()>=SIZE){return null;}
        else return this.room[(int)position.getY()][(int)position.getX()];
    }
    
}
