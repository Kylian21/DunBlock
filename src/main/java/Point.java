/*
 * DunBlock JAVA project
 */

/**
 *
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class Point {
    private float x;
    private float y;
    
    /**
     * Construct a point by giving two float
     * @param x
     * @param y 
     */
    public Point(float x,float y){
        this.x=x;
        this.y=y;
    }
    /**
     * 
     * @return the position X
     */
    public float getX(){
        return this.x;
    }
    /**
     * 
     * @return the position Y
     */
    public float getY(){
        return this.y;
    }
    /**
     * 
     * @param value the value of the position X
     */
    public void setX(float value){
        this.x = value;
    }
    /**
     * 
     * @param value the value of the position Y
     */
    public void setY(float value){
        this.y = value;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
