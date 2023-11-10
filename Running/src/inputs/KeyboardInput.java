package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInput(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeYDelta(-15);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-15);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(15);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(15);
                break;
            default:
                System.out.println("Random Key is currently being pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
