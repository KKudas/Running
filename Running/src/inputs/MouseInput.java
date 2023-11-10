package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {

    private GamePanel gamePanel;
    public MouseInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse is clicked!");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered JFrame");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited JFrame");
    }


    //MOUSE MOTION LISTENER
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //gamePanel.followMousePointer(e.getX(), e.getY());
    }
}
