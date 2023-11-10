package main;

import inputs.KeyboardInput;
import inputs.MouseInput;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInput mouseInput;
    private float xDelta = 100, yDelta = 100;
    private float xDir = 0.1f, yDir = 0.1f;
    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(150,20,50);
    private Random random;
    public GamePanel(){
        random = new Random();
        mouseInput = new MouseInput(this);
        setPanelSize();
        addKeyListener(new KeyboardInput(this));
        addMouseListener(mouseInput);
        addMouseMotionListener(mouseInput);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280,720);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);

    }

    //MOVEMENTS
    public void changeXDelta(int value){
        this.xDelta += value;
    }

    public void changeYDelta(int value){
        this.yDelta += value;
    }

    public void followMousePointer(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        updateRect();

        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta,50,50);

    }

    private void updateRect() {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0){
            color = getRandomClr();
            xDir *= -1;
        }

        yDelta += yDir;
        if(yDelta > 400 || yDelta < 0){
            color = getRandomClr();
            yDir *= -1;
        }
    }

    private Color getRandomClr() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }
}
