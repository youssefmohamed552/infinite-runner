package game;

import gnd.Ground;
import pl.Player;

import java.awt.*;

public class Game {
    public Ground ground;
    public Player player;
    public Canvas canvas;
    public static final int STEP = 10;


    public Game(Canvas canvas){
        ground = new Ground(this , 10);
        player = new Player(this);
//        this.canvas = canvas;
    }

    public void draw(Graphics g){
        if(ground == null || player == null) return;
        ground.draw(g);
        player.draw(g);
    }

    public void move(){
        ground.move();
        player.move();
        // player.jump();
    }


}
