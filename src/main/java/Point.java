/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kylian Salomon
 */
public class Point {
    private float x;
    private float y;
    
    public Point(float x,float y){
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return this.x;
    }
    
    public float getY(){
        return this.y;
    }
    
    public void setX(float value){
        this.x = value;
    }
    
    public void setY(float value){
        this.y = value;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
    
}
