
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
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Point[] listOfChoice = new Point[4];
        boolean END = false;
        Dungeon donjon = new Dungeon(5,5);
        Point position = new Point(0,0);
        Hero hero = new Hero(position, 50, newHero());
        donjon.dungeonGenerator(hero);
        
        while(!END){
            donjon.printDungeon();
            hero.printHeroInfo();
            System.out.println(hero.position);
            listOfChoice = possibilities(hero,donjon);
            System.out.println("Entrez votre choix : ");
            String choice = keyboard.nextLine();
            
            switch(choice.charAt(0)){
                case'U':
                    action(hero,donjon.getBloc(listOfChoice[0]),donjon.getBloc(hero.position));
                    break;
                case'D':
                    action(hero,donjon.getBloc(listOfChoice[1]),donjon.getBloc(hero.position));
                    break;
                case'L':
                    action(hero,donjon.getBloc(listOfChoice[2]),donjon.getBloc(hero.position));
                    break;
                case'R':
                    action(hero,donjon.getBloc(listOfChoice[3]),donjon.getBloc(hero.position));
                    break;
            }
            
        }
            
  }
   
    public static Point[] possibilities(Hero hero, Dungeon donjon){
        char keyboardList[]  = {'U','D','L','R'};
        Point [] blocList = new Point[4];
        Point positionUp = new Point(hero.position.getX(),hero.position.getY()-1);
        Point positionDown = new Point(hero.position.getX(),hero.position.getY()+1);
        Point positionLeft = new Point(hero.position.getX()-1,hero.position.getY());
        Point positionRight = new Point(hero.position.getX()+1,hero.position.getY());
       
        blocList[0]=positionUp;
        blocList[1]=positionDown;
        blocList[2]=positionLeft;
        blocList[3]=positionRight;
        System.out.println();
        for (int i=0;i<4;i++){
           Bloc tmp = donjon.getBloc(blocList[i]);
           
           if(tmp == null){System.out.println(keyboardList[i]+" : Vous ne pouvez pas aller dans cette direction !");}
           
           else if(tmp instanceof MineralBloc){
               if(!((MineralBloc)tmp).isBlocMined()){
                System.out.println(keyboardList[i]+" : Vous pouvez miner un bloc de "+((MineralBloc)tmp).getMineralType()+" ?");
               }
               else System.out.println(keyboardList[i]+" : Le minerai a déja été miné, vous pouvez aller dans cette direction !");
           }
           
           else if(tmp instanceof ChestBloc){
               if(((ChestBloc)tmp).isEmptyChest()){
                   System.out.println(keyboardList[i]+" : The chest is already open !");
               }
               else{
               System.out.println(keyboardList[i]+" : You found a chest, Open it ?");}
           }
           
           else if(tmp.getCharacter() instanceof Monster){System.out.println(keyboardList[i]+" : Affronter le monstre ?");}
           
           else{System.out.println(keyboardList[i]+" : Vous pouvez aller dans cette direction !");}
        }
        
        return blocList;
    }
    
    public static void action(Hero hero, Bloc bloc, Bloc oldBloc){
        
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
                hero.setTool(((ChestBloc)bloc).getTool());
                ((ChestBloc)bloc).setEmptyChest(true);
            }
        }
        else if(bloc.getCharacter() instanceof Monster){
            boolean result = attackaMonster((Monster)bloc.getCharacter(), hero);
            if(result){
                bloc.setCharacter(null);
            }
        }
        else if(bloc instanceof TrapBloc){
            
        }
        else{
            hero.move(bloc.getPosition());
            bloc.setCharacter(hero);
            oldBloc.setCharacter(null);
        }
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
        Random rand=new Random();
        
        while(monster.healthPoint>0 && hero.healthPoint>0){
            int rdmMonsterAttack=rand.nextInt(6);
            int rdmHeroAttack=rand.nextInt(6);
            monster.healthPoint-=hero.attack[rdmHeroAttack];
            hero.healthPoint-=monster.attack[rdmMonsterAttack];
            System.out.println(hero.attack[rdmHeroAttack]);
            System.out.println(monster.name+"HP ="+monster.healthPoint);
            System.out.println(hero.name+"HP ="+hero.healthPoint);
        }
        if(monster.healthPoint<=0){
            System.out.println("YOU KILL THE MONSTER");
            return true;
        }
        else{
            System.out.println("YOU ARE DEAD");
            return false;
        }
    }
}   
