/*
 * DunBlock JAVA project
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Class with the main method where the game is launch.
 * @author Louis HARISMENDY & Kylian SALOMON
 */

public class Play {
    public static void main(String[] args) throws Exception{
        Scanner keyboard = new Scanner(System.in);
        Point[] listOfChoice = new Point[4];
        
        /*Boolean for ending*/
        boolean END = false;
        
        /*DUNGEON SIZE DEFINED HERE*/
        Dungeon donjon = new Dungeon(10);
        Point position = new Point(0,0);
        
        /*Create the Hero of the game*/
        Hero hero = new Hero(position, 50, newHero());
        
        /*Dugeon Generation*/
        donjon.dungeonGenerator(hero);
        
        /*GAME*/
        while(!END){
            donjon.printDungeon();
            hero.printHeroInfo();
            listOfChoice = possibilities(hero,donjon);
            System.out.println("ENTER YOUR CHOICE :");
            String choice = keyboard.nextLine().toUpperCase();

            try{
                /*The user enter a char and we test the char to run the action
                 The END Boolean is test at every action if we need to stop the game*/
                switch(choice.charAt(0)){
                    case'U':
                        END=action(hero,donjon.getBloc(listOfChoice[0]),donjon.getBloc(hero.getPosition()));
                        break;
                    case'D':
                        END=action(hero,donjon.getBloc(listOfChoice[1]),donjon.getBloc(hero.getPosition()));
                        break;
                    case'L':
                        END=action(hero,donjon.getBloc(listOfChoice[2]),donjon.getBloc(hero.getPosition()));
                        break;
                    case'R':
                        END=action(hero,donjon.getBloc(listOfChoice[3]),donjon.getBloc(hero.getPosition()));
                        break;
                    case'I':
                        System.out.println("INVENTORY :");
                        hero.printInventory();
                        break;
                    default:
                        throw new Exception("INVALIDE INPUT ! ENTER U(up),D(down),L(left),R(right) or I(inventory).");
                }           
            }
            catch (Exception err){
                System.out.println("ERROR : "+err.getMessage());
            }     
        }
    }
   
    /**
     * Test all the possibilities around the hero and print them.
     * @see Hero
     * @see Dungeon
     * @param hero the hero of the game
     * @param donjon the dungeon generated
     * @return return the position of the block around the hero
     */
    public static Point[] possibilities(Hero hero, Dungeon donjon){
        char keyboardList[]  = {'U','D','L','R','I'};
        Point [] blocList = new Point[4];
        Point positionUp = new Point(hero.getPosition().getX(),hero.getPosition().getY()-1);
        Point positionDown = new Point(hero.getPosition().getX(),hero.getPosition().getY()+1);
        Point positionLeft = new Point(hero.getPosition().getX()-1,hero.getPosition().getY());
        Point positionRight = new Point(hero.getPosition().getX()+1,hero.getPosition().getY());
       
        blocList[0]=positionUp;
        blocList[1]=positionDown;
        blocList[2]=positionLeft;
        blocList[3]=positionRight;
        System.out.println();
        for (int i=0;i<4;i++){
           Bloc tmp = donjon.getBloc(blocList[i]);
           //Limit of the map
           if(tmp == null){System.out.println(keyboardList[i]+" : You can't go this way !");}
           
           else if(tmp instanceof MineralBloc){
               if(!((MineralBloc)tmp).isBlocMined()){
                System.out.println(keyboardList[i]+" : You can mine a bloc of "+((MineralBloc)tmp).getMineralType()+" ?");
               }
               else System.out.println(keyboardList[i]+" : You already mined this bloc, you can go this way !");
           }
           
           else if(tmp instanceof ChestBloc){
               if(((ChestBloc)tmp).isEmptyChest()){
                   System.out.println(keyboardList[i]+" : The chest is already open !");
               }
               else{
               System.out.println(keyboardList[i]+" : You found a chest, Open it ?");}
           }
           
           else if(tmp.getCharacter() instanceof Monster){
               System.out.println(keyboardList[i]+" : Do you want to fight the "+tmp.getCharacter().name+" ?");
           }
           else{System.out.println(keyboardList[i]+" : You can go this way !");}
        }
        System.out.println(keyboardList[4]+" : Open the inventory");
        return blocList;
    }
    
    /**
     * When call, run the actions choosen by the user.
     * @see Hero
     * @see Bloc
     * @param hero of the game
     * @param bloc the future bloc where the hero will be
     * @param oldBloc the bloc where the hero is
     * @return the END Boolean (true to stop the game)
     */
    public static boolean action(Hero hero, Bloc bloc, Bloc oldBloc){
        //Limit of the map
        if(bloc == null){
            System.out.println("You shall not pass");
        }
        //MineralBloc
        else if(bloc instanceof MineralBloc){
            //The hero mine the bloc, drop lingot
            if(!((MineralBloc)bloc).isBlocMined()){
               ((MineralBloc)bloc).dropLingot(((MineralBloc)bloc).getMineralType(), hero);
               ((MineralBloc)bloc).setBlocMined(true);
            }
            //If it the bloc is already mined : the hero move to this bloc
            else{
                hero.move(bloc.getPosition());
                bloc.setCharacter(hero);
                oldBloc.setCharacter(null);
            }
        }
        //Chest
        else if(bloc instanceof ChestBloc){
            //Open the chest, take the tool inside
            if(!((ChestBloc)bloc).isEmptyChest()){
                System.out.println("You found a "+((ChestBloc)bloc).getTool());
                hero.setTool(((ChestBloc)bloc).getTool());
                ((ChestBloc)bloc).setEmptyChest();
            }
        }
        //Monster
        //Attack the monster, IF the hero kill the monster then it disapear
        else if(bloc.getCharacter() instanceof Monster){
            boolean result = attackaMonster((Monster)bloc.getCharacter(), hero);
            if(result){
                bloc.setCharacter(null);
            }
            //Stop the game if the hero died
            else{
                return true;
            }
        }
        //Trap
        //The hero take damage by moving to this bloc
        else if(bloc instanceof TrapBloc){
            hero.move(bloc.getPosition());
            bloc.setCharacter(hero);
            oldBloc.setCharacter(null);
            if (!((TrapBloc) bloc).isActivated()){
                boolean result = trapped((TrapBloc)bloc,hero);
                if(result){
                    ((TrapBloc) bloc).setActivated(true);
                }
                //Stop the game if the hero died
                else{
                    return true;
                }
            }
        }
        //Simple bloc empty : the hero move to this bloc
        else{
            hero.move(bloc.getPosition());
            bloc.setCharacter(hero);
            oldBloc.setCharacter(null);
        }
        //default : return false to not stop the game
        return false;
    }
    
    /**
     * Display the beginning of the game.
     * Ask the user to enter is initials.
     * @return the name of the hero
     */
    public static String newHero(){
        String heroName;
        Scanner nameInput = new Scanner(System.in);
        System.out.println("WELCOME TO DUNBLOCK !");
        System.out.println("ENTER YOUR INITIALS");
        while(true){
            heroName=nameInput.nextLine();
            try{
                if(heroName.length()<=3){
                    System.out.println("WELCOME "+heroName+" !");
                    break;
                }
                else throw new Exception("INITIALS LENGTH MUST BE UNDER 3");
            }catch (Exception err){
                System.out.println("ERROR : "+err.getMessage());
            }
        }
        return heroName;
    }
    
    /**
     * Fight between a monster and hero. The hero attack first and the fight finish when one of the two is dead
     * @param monster the monster in the fight
     * @param hero the hero in the fight
     * @return the result of the fight (false the hero is dead,true the monster is dead)
     */
    public static boolean attackaMonster(Monster monster,Hero hero){
        while(monster.isAlive() && hero.isAlive()){
            System.out.print(hero.name);
            hero.attackaCharacter(monster, hero.getAttack());
            if(monster.healthPoint>=0){
                System.out.print(monster.name);
                monster.attackaCharacter(hero, monster.getAttack());
            }
        }
        if(!monster.isAlive()){
            System.out.println("YOU KILL THE MONSTER");
            monster.dropLingot(monster.getMineralType(), hero);
            return true;
        }
        else{
            System.out.println("YOU ARE DEAD");
            return false;
        }
    }
    
    /**
     * When a hero enter a trap : the trap attack the hero.
     * @param trap the trap selected
     * @param hero the hero trapped
     * @return the result of the trap (false the hero is dead,true the monster is dead)
     */
    public static boolean trapped(TrapBloc trap,Hero hero){
        trap.attackaCharacter(hero, trap.getAttack());
        System.out.println("YOU HAVE BEEN TRAPPED");
        if(!hero.isAlive()){
            System.out.println("YOU ARE DEAD");
            return false;
        }
        return true;
    }
}   
