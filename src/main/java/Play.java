
import java.util.Random;
import java.util.Scanner;

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
    public static void main(String[] args) throws Exception{
        Scanner keyboard = new Scanner(System.in);
        Point[] listOfChoice = new Point[4];
        
        /*Boolean for ending*/
        boolean END = false;
        Dungeon donjon = new Dungeon(10);
        Point position = new Point(0,0);
        
        Hero hero = new Hero(position, 50, newHero());
        donjon.dungeonGenerator(hero);
        
        while(!END){
            donjon.printDungeon();
            hero.printHeroInfo();
            listOfChoice = possibilities(hero,donjon);
            System.out.println("ENTER YOUR CHOICE :");
            String choice = keyboard.nextLine().toUpperCase();

            try{
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
    
    public static boolean action(Hero hero, Bloc bloc, Bloc oldBloc){
        if(bloc == null){
            System.out.println("You shall not pass");
        }
        
        else if(bloc instanceof MineralBloc){

            if(!((MineralBloc)bloc).isBlocMined()){
               ((MineralBloc)bloc).dropLingot(((MineralBloc)bloc).getMineralType(), hero);
               ((MineralBloc)bloc).setBlocMined(true);
            }
            else{
                hero.move(bloc.getPosition());
                bloc.setCharacter(hero);
                oldBloc.setCharacter(null);
            }
        }
        else if(bloc instanceof ChestBloc){
            
            if(!((ChestBloc)bloc).isEmptyChest()){
                System.out.println("You found a "+((ChestBloc)bloc).getTool());
                hero.setTool(((ChestBloc)bloc).getTool());
                ((ChestBloc)bloc).setEmptyChest();
            }
        }
        else if(bloc.getCharacter() instanceof Monster){
            boolean result = attackaMonster((Monster)bloc.getCharacter(), hero);
            if(result){
                bloc.setCharacter(null);
            }
            else{
                return true;
            }
        }
        else if(bloc instanceof TrapBloc){
            hero.move(bloc.getPosition());
            bloc.setCharacter(hero);
            oldBloc.setCharacter(null);
            if (!((TrapBloc) bloc).isActivated()){
                boolean result = trapped((TrapBloc)bloc,hero);
                if(result){
                    ((TrapBloc) bloc).setActivated(true);
                }
                else{
                    return true;
                }
            }
        }
        else{
            hero.move(bloc.getPosition());
            bloc.setCharacter(hero);
            oldBloc.setCharacter(null);
        }
        return false;
    }
    
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
    
    public static boolean attackaMonster(Monster monster,Hero hero){
        while(monster.healthPoint>0 && hero.healthPoint>0){
            System.out.print(hero.name);
            hero.attackaCharacter(monster, hero.getAttack());
            if(monster.healthPoint>=0){
                System.out.print(monster.name);
                monster.attackaCharacter(hero, monster.getAttack());
            }
        }
        if(monster.healthPoint<=0){
            System.out.println("YOU KILL THE MONSTER");
            monster.dropLingot(monster.getMineralType(), hero);
            return true;
        }
        else{
            System.out.println("YOU ARE DEAD");
            return false;
        }
    }
    
    public static boolean trapped(TrapBloc trap,Hero hero){
        trap.attackaCharacter(hero, trap.getAttack());
        System.out.println("YOU HAVE BEEN TRAPPED");
        if(hero.healthPoint<=0){
            System.out.println("YOU ARE DEAD");
            return false;
        }
        return true;
    }
}   
