/*
 * DunBlock JAVA project
 */


/**
 * Class with parameters of a tool
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Tool implements LingotDrop{
    private final Mineral MineralType = randomMineral();
    /**
     * To get the MineralType of a tool
     * @return The mineral type of the tool
     */
    public Mineral getMineralType() {
        return MineralType;
    }
}
