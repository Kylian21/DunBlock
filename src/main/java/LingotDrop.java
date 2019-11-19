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
        if(null != mineralsType)switch (mineralsType) {
            case Iron:
                hero.setLingot((int)_randomNumber, 0);
                break;
            case Gold:
                hero.setLingot((int)_randomNumber, 1);
                break;
            case Diamond:
                hero.setLingot((int)_randomNumber, 2);
                break;
            default:
                break;
        }
    }
}
