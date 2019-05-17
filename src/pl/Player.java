package pl;

import gnd.Ground;
import game.Canvas;
import gnd.GroundTile;
import game.GameObject;
import game.Game;


import java.awt.*;

public class Player extends GameObject{
    private final int LEFT_BOUND = 100;
    private final int WIDTH = 50;
    private final int HEIGHT = 100;
    private int ground_base;
    private boolean is_jumping;
    private boolean going_up;
    private boolean going_down;
    private int max_height;
    private int off_ground;


    Ground ground;

    public Player(Game parent){
        game = parent;
        x = LEFT_BOUND;
        y = 0;
        this.height = HEIGHT;
        this.width = WIDTH;
        is_jumping = false;
        max_height = 10;
        off_ground = 0;

    }

    public void draw(Graphics g){
        // System.out.printf("x: %d , y: %d \n",x,y);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.fillOval(x+(WIDTH/2)+5 , y+20 , 10,10);
    }

    public void move(){
        if(is_jumping){
            jump();
            return;
        }
        moveDown();
        Ground.Behaviour todo =  game.ground.collidesWith(this);
        if(todo == Ground.Behaviour.STAY){
            moveUp();
            return;
            //System.out.println("y: " + y);
        }
        if(todo == Ground.Behaviour.LEFT){
            moveUp();
            moveLeft();
            return;
        }



//        return;
//        int new_y = canvas.getHeight() - ((ground.getHeightAt(x+WIDTH) + HEIGHT) + (height * GroundTile.STEP));
//        if(new_y <= y){
//            y = new_y;
//            return;
//        }
//        y = canvas.getHeight() - ((ground.getHeightAt(x) + HEIGHT) +(height * GroundTile.STEP));
    }

    public void moveRight(){
        if(x+WIDTH < game.canvas.getWidth())x += GroundTile.STEP;
    }

    public void moveLeft(){
//        if(x > LEFT_BOUND) x-= GroundTile.STEP;
        x -= Game.STEP;
    }

    public void moveUp(){
        y -= Game.STEP;
//        if(height >= max_height) {
//            going_up = false;
//            going_down = true;
//            return;
//        }
//        if(height == 0){
//            ground_base = ground.getHeightAt(x);
//            going_up = true;
//        }
//        if(going_up){
//            y-= GroundTile.STEP;
//            System.out.println("going up and y is " + y);
//            going_up = true;
//            height++;
//            return;
//        }

    }

    public void moveDown(){
        // maintain gravity
        // if(collidesWith())y+= GroundTile.STEP;

//        if(!going_down) return;
//        if(y + HEIGHT <= ground.getHeightAt(x)){
//            going_down = false;
//            jumping = false;
//            return;
//        }
//        System.out.println("going down");
//        y+= GroundTile.STEP;
//        height--;
        y += Game.STEP;
//        if(game.ground.collidesWith(this) == Ground.Behaviour.STAY){
//            y -= Game.STEP;
//            //System.out.println("y: " + y);
//        }

    }

    public void jump(){
//        if(!jumping) return;
        System.out.println("jumping");
        if(off_ground < max_height){
            moveUp();
            off_ground++;
            return;
        }
        off_ground = 0;
        is_jumping = false;

        //moveDown();
    }

    public void setIsJumping(boolean j){
        is_jumping = j;
    }


}
