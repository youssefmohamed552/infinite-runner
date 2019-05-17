package gnd;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import game.Canvas;
import game.Game;
import game.GameObject;

public class Ground {
    private int _x;
    private int _y;
    private int blocks_count;
    private LinkedList<GroundBlock> blocks;
    private final int initial_height = 4;
    private Canvas canvas;

    public enum Behaviour{
        STAY,
        LEFT,
        DOWN;
    }

    public Ground(Game parent , int count){
        _x = 0;
        _y = Canvas.HEIGHT - (initial_height * GroundTile.HEIGHT);
        blocks_count = count;
        blocks = new LinkedList<>();
        init_ground(parent);
    }

    private void init_ground(Game parent){
        if(blocks == null) return;

        int w = 5;
        int x = _x;
        int prev_h = 0;
        int h = initial_height;
        Random random = new Random();
        //int h = random.nextInt(6)+1;
        for(int i = 0; i < blocks_count;i++){
            prev_h = h;
            blocks.add(new GroundBlock(parent, x , Canvas.HEIGHT - ( h * GroundTile.HEIGHT ), h , w));
            x += (GroundTile.WIDTH*w);
            h = random.nextInt(6)+1;
            while(Math.abs(h - prev_h) > 2){
                h = random.nextInt(6)+1;
            }
            // System.out.println("dimensions : "+h + ":" + 5);
        }
    }

    public void draw(Graphics g){
        if(blocks == null) return;
        for(GroundBlock block: blocks){
            block.draw(g);
        }
    }

    public void move(){
        for(GroundBlock block : blocks){
            block.move();
        }
        _x -= GroundTile.STEP;
    }

    public int getHeightAt(int pos){
        int height = 0;
        for(GroundBlock block: blocks){
            if(block.getX() < pos) {
                height = (int)block.getHeight() * GroundTile.HEIGHT;
            }
            else{
                break;
            }
        }
        return height;
    }

    public Behaviour collidesWith(GameObject other) {
        Iterator<GroundBlock> it_b = blocks.iterator();
        GroundBlock b_prev = it_b.next();
        while(it_b.hasNext()){
            GroundBlock b = it_b.next();
            if(b_prev.collidesWith(other)){
                if(b_prev.getHeight() != b.getHeight() &&  b.collidesWith(other)) {
//                    System.out.println("LEFT");
                    return Behaviour.LEFT;
                }
//                System.out.println("STAY");
                return Behaviour.STAY;

            }

            b_prev = b;
        }
//        for(GroundBlock b : blocks){
//            if(b.collidesWith(other)){
//                return true;
//            }
//        }
//        System.out.println("DOWN");
        return Behaviour.DOWN;
    }
}
