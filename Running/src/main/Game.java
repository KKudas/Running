package main;

public class Game implements Runnable{
    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int SET_FPS = 60; //Sets fps limit

    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    //STARTS THE GAME
    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timeFrame = 1000000000.00/SET_FPS;
        long lastFrame = System.nanoTime();
        long currentTime;
        int frames = 0;
        long lastCheck = System.currentTimeMillis();
        //
        //LOGIC IS (CURRENT TIME - TIME TO REACH A SECOND) >= TIME ALLOWED PER SECOND
        while(true){
            currentTime = System.nanoTime();
            if(currentTime - lastFrame >= timeFrame){
                gamePanel.repaint();
                lastFrame = currentTime;
                frames++;
            }

            //            CURRENT SEC       LAST SEC    1sec
            if(System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
