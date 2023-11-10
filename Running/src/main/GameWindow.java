package main;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GamePanel gamePanel){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//CLOSES THE WINDOW
//        this.setLocationRelativeTo(null); //CENTERS THE WINDOW
        this.add(gamePanel);
        this.setResizable(false);
        this.pack(); //It puts the gamepanel on the gamewindow without changing the mentioned variables
        this.setVisible(true);
    }
}
