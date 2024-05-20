package Main;

public class Game implements  Runnable{
    private GamePanel gamePanel = new GamePanel();
    private GameWindow gameWindow ;
    private int FPS = 144;
    private int UPS = 144;
    Thread gameThread;
    public Game(){
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        gameThread = new Thread(this::run);
        gameThread.run();
    }

    @Override
    public void run() {
        double timePerFrame =  1000000000.0 /FPS;
        double timePerUpdate =  1000000000.0 /UPS;
        int frame = 0;
        double deltaU = 0;
        double deltaF = 0;
        int UPStick = 0;
        long lastCheck = System.nanoTime();
        long previusTime = System.nanoTime();

        while (true){

            long current = System.nanoTime();
            deltaF += (current-previusTime)/timePerFrame;
            deltaU += (current- previusTime)/timePerUpdate;

            if (deltaU >=1){
//                update();
                UPStick++;
                deltaU--;
            }

            if (deltaF >=1){
                gamePanel.repaint();
                frame ++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS" + frame +"   ||   " + "UPS" +UPStick);
                frame =0;
                UPStick=0;
        }
            previusTime = current;


        }
    }
}
