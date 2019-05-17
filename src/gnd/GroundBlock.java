package gnd;

import game.Game;
import game.GameObject;

import java.awt.*;

public class GroundBlock extends GameObject {


    private GroundTile[][] tiles;

    public GroundBlock(Game parent , int x , int y , int length , int width){
        this.x = x;
        this.y = y;
        this.height = length * GroundTile.HEIGHT;
        this.width = width * GroundTile.WIDTH;
        tiles = new GroundTile[width][length];
        game = parent;
        init_block();
    }

    public void init_block(){
        if(tiles == null) return;
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                tiles[i][j] = new GroundTile(x + (i * GroundTile.WIDTH) , y + (j * GroundTile.HEIGHT));
            }
        }
    }

    public void draw(Graphics g){
        if(tiles == null) return;
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(x < 100) tiles[i][j].setColor(Color.CYAN);
                tiles[i][j].draw(g);
            }
        }
    }

    public void move(){
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                tiles[i][j].move();
            }
        }
        x -= GroundTile.STEP;
    }




}
