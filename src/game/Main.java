package game;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("infinite runner");
        frame.add(new Canvas());
        //frame.setSize(Canvas.WIDTH,Canvas.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
