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
    
    /**
     * @see Point
     * @param position 
     *          The position of the bloc.
     */
    public Bloc(Point position) {
        this.position = position;
    }
    
    /**
     * @see Point
     * @return the position of the bloc
     */
    public Point getPosition() {
        return position;
    }
    
    /**
     * @see Point
     * @param position 
     *          The position of the bloc. 
     */
    public void setPosition(Point position) {
        this.position = position;
    }
    
    /**
     * 
     * @see Character
     * @param character The character who will be inside the bloc
     */
    public void setCharacter(Character character) {
        this.character = character;
    }
    
    /**
     * @see Character
     * @return the character in the bloc.
     */
    public Character getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        if(this.character instanceof Monster){return "M";}
        else if(this.character instanceof Hero){return "H";}
        else return " ";
    }
}
