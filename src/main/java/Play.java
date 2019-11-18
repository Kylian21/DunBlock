
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
        boolean END = false;
        Dungeon donjon = new Dungeon(5,5);
        Point position = new Point(0,0);
        Hero hero = new Hero(position, 30, newHero());
        donjon.dungeonGenerator(hero);
        while(!END){
            donjon.printDungeon();
            hero.printHeroInfo();
            break;
        }
  }
   
    public Point[] possibilities(Hero hero, Dungeon donjon){
        Point [] choiceList = new Point[4];
        Point positionUp = new Point(hero.position.getX(),hero.position.getY()-1);
        Point positionDown = new Point(hero.position.getX(),hero.position.getY()+1);
        Point positionLeft = new Point(hero.position.getX()-1,hero.position.getY());
        Point positionRight = new Point(hero.position.getX()+1,hero.position.getY());
        choiceList[0]=positionUp;
        choiceList[1]=positionDown;
        choiceList[2]=positionLeft;
        choiceList[3]=positionRight;
        
        return choiceList;
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
