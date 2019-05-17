package gnd;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;
import game.Canvas;

public class GroundTile {
    private int _x;
    private int _y;
//    private int _x_ord;
//    private int _y_ord;
    private Rectangle dim;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public static final int STEP = 10;
    private Color _color;

    public GroundTile(int x, int y){
//        _x_ord = x_ord;
//        _y_ord = y_ord;
        _x = x; //+ (_x_ord * WIDTH);
        _y = y; //+ (_y_ord * HEIGHT);
        _color = Color.GREEN;
    }


    public void draw(Graphics g){
        dim = g.getClipBounds();
        //System.out.println("height : " + + " _y : " + _y);
        g.setColor(_color);
        g.fillRect(_x , ((int)dim.getHeight() - Canvas.HEIGHT) + _y , WIDTH , HEIGHT);
        g.setColor(Color.BLACK);
        g.drawRect(_x , ((int)dim.getHeight() - Canvas.HEIGHT) + _y , WIDTH , HEIGHT);
    }

    public void move(){
        _x -= STEP;
    }

    public void setColor(Color color){
        _color = color;
    }

//    public int getWidth(){
//        return WIDTH;
//    }
//    public int getHeight(){
//        return HEIGHT;
//    }

}
