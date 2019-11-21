/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This interface contains all the methods linked to the creation
 *  of the lingots and the dropping method. 
 * @author Kylian Salomon
 */
public interface LingotDrop {
    /**
     * Create a mineral randomly
     * @return the random Mineral
     * @see Mineral
     */
    default Mineral randomMineral(){
        double randomNumber = Math.random()*(100);
       if(randomNumber<=10)return Mineral.Diamond;
       else if(randomNumber<=40)return Mineral.Gold;
       else return Mineral.Iron;
    }
    /**
     * When this method is called, the hero will receive a amount of lingots
     * @param mineralsType The type of the lingot
     * @param hero The hero of the Dungeon
     * @see Mineral
     * @see Hero
     * @see PickAxe
     * @see Hero#getItem(int) 
     * @see PickAxe#getPickAxeAdvantage()
     * @see Hero#addLingot(int, int) 
     */
    default void dropLingot(Mineral mineralsType, Hero hero){
        double _randomNumber = (Math.random()*(2))+1;
       
        if(hero.getItem(1)!=null){
            _randomNumber+=((PickAxe)hero.getItem(1)).getPickAxeAdvantage();
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
