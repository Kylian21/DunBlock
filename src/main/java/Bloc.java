/*
 * DunBlock JAVA project
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Bloc {
    private Point position;
    Character character;

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
    
}
