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
    default int dropLingot(Mineral mineralsType){
        double _randomNumber = (Math.random()*(2))+1;
        return (int)_randomNumber;
    }
}
