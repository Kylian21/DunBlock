/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class PickAxe extends Tool{
    
    public void breakMineralBloc(MineralBloc bloc){
        bloc.setBlocMined(true);
    }

    @Override
    public String toString() {
        return super.getMineralType()+"PickAxe";
    }
}
