
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
        Bloc[] listOfChoice = new Bloc[4];
        boolean END = false;
        Dungeon donjon = new Dungeon(5,5);
        Point position = new Point(0,0);
        Hero hero = new Hero(position, 30, newHero());
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
                    action(hero,listOfChoice[0],donjon.getBloc(hero.position));
                    break;
                case'D':
                    action(hero,listOfChoice[1],donjon.getBloc(hero.position));
                    break;
                case'L':
                    action(hero,listOfChoice[2],donjon.getBloc(hero.position));
                    break;
                case'R':
                    action(hero,listOfChoice[3],donjon.getBloc(hero.position));
                    break;
            }
            
        }
            
  }
   
    public static Bloc[] possibilities(Hero hero, Dungeon donjon){
        char keyboardList[]  = {'U','D','L','R'};
        Bloc [] blocList = new Bloc[4];
        Point positionUp = new Point(hero.position.getX(),hero.position.getY()-1);
        Point positionDown = new Point(hero.position.getX(),hero.position.getY()+1);
        Point positionLeft = new Point(hero.position.getX()-1,hero.position.getY());
        Point positionRight = new Point(hero.position.getX()+1,hero.position.getY());
       
        blocList[0]=donjon.getBloc(positionUp);
        blocList[1]=donjon.getBloc(positionDown);
        blocList[2]=donjon.getBloc(positionLeft);
        blocList[3]=donjon.getBloc(positionRight);
        System.out.println();
        for (int i=0;i<4;i++){
           if(blocList[i] == null){System.out.println(keyboardList[i]+" : Vous ne pouvez pas aller dans cette direction !");}
           else if(blocList[i] instanceof MineralBloc){
               MineralBloc tmp = (MineralBloc) blocList[i];
               if(!tmp.isBlocMined()){
                System.out.println(keyboardList[i]+" : Vous pouvez miner un bloc de "+tmp.getMineralType()+" ?");
               }
               else System.out.println(keyboardList[i]+" : Le minerai a déja été miné, vous pouvez aller dans cette direction !");
           }
           else if(blocList[i].getCharacter()!= null){System.out.println(keyboardList[i]+" : Affronter le monstre ?");}
           else if(blocList[i] instanceof ChestBloc){
               System.out.println(keyboardList[i]+"You found a chest, Open it ?");
           }
           else{System.out.println(keyboardList[i]+" : Vous pouvez aller dans cette direction !");}
        }
        
        return blocList;
    }
    
    public static void action(Hero hero, Bloc bloc, Bloc oldBloc){
        if(bloc == null){System.out.println("You shall not pass");}
        else if(bloc instanceof MineralBloc){
            MineralBloc tmp = (MineralBloc) bloc;
            if(!tmp.isBlocMined()){
               tmp.dropLingot(tmp.getMineralType(), hero);
               tmp.setBlocMined(true);
            }
            else{
                hero.move(bloc.getPosition());
                bloc.setCharacter(hero);
                oldBloc.setCharacter(null);
            }
        }
        else if(bloc instanceof ChestBloc){
            
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
    
    public static void attackaMonster(Monster monster,Hero hero){
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
            hero.position=monster.position;
        }
        else if(hero.healthPoint<=0){
            System.out.println("YOU ARE DEAD");
        }
    }
}   
