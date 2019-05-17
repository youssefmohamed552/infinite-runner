package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Canvas extends JPanel{
    Game game;
    Timer timer;

    public static final int HEIGHT = 600;
    public static final int WIDTH = 1000;

    public Canvas(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        game = new Game(this);
        timer = new Timer(100, new Drawer());
        timer.start();

        addKeyListener(new PlayerActions());
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        if(game == null) return;
        game.draw(g);
    }

    public void move(){
        game.move();
    }

    class Drawer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            move();
            repaint();
        }
    }

    class PlayerActions implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                game.player.setIsJumping(true);
            }
            else if(e.getKeyCode() == KeyEvent.VK_LEFT){
                game.player.moveLeft();
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                game.player.moveRight();
            }
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}
