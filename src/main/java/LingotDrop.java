/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public interface LingotDrop {
    default Mineral randomMineral(){
        double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    default void dropLingot(Mineral mineralsType, Hero hero){
        double _randomNumber = (Math.random()*(2))+1;
        switch(hero.getItem(1).getMineralType()){
            case Iron: 
                _randomNumber += 1;
                break;
            case Gold: 
                _randomNumber+=3;
                break;
            case Diamond: 
                _randomNumber+=5;
                break;
            default:
                break;
        }
        if(null != mineralsType)switch (mineralsType) {
            case Iron:
                hero.addLingot((int)_randomNumber, 0);  
                break;
            case Gold:
                hero.addLingot((int)_randomNumber, 1);
                break;
            case Diamond:
                hero.addLingot((int)_randomNumber, 2);
                break;
            default:
                break;
        }
    }
}
