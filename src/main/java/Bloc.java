/*
 * DunBlock JAVA project
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Bloc {
    private Point position;
    private Character character;

    public Bloc(Point position) {
        this.position = position;
    }
    
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
    
    @Override
    public String toString() {
        if(this.character instanceof Monster){return "M";}
        else if(this.character instanceof Hero){return "H";}
        else return " ";
    }
}
