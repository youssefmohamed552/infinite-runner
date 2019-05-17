package game;

import java.awt.Rectangle;
import java.awt.Graphics;

public abstract class GameObject extends Rectangle{

    //defining the dimensions

    protected Game game;



    public abstract void move();

    public abstract void draw(Graphics g);


    public boolean collidesWith(GameObject other){
        //System.out.println("y: " + y + " y_other: " + other.y + " height: " + height + " height_other: " + other.height);
//        if((x < other.x + other.width) && (x + width > other.x) && (y < other.y + other.height) && (y + height > other.y)){
//            System.out.println("found colision");
//            return true;
//        }
//        if(intersects(other)){
//
//        }
//        System.out.println("out");
//        return false;
        return intersects(other);
    }


    public double getX(){ return x; }

    public double getHeight(){ return height; }

    public double getWidth() { return width; }

}
