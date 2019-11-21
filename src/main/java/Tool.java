/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class with parameters of a tool
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Tool implements LingotDrop{
    private final Mineral MineralType = randomMineral();

    public Mineral getMineralType() {
        return MineralType;
    }
}
