package Main;

import Entity.Player;
import Levels.LevelManager;

import java.awt.*;
import java.security.PublicKey;

public class Game implements  Runnable{
    private GamePanel gamePanel = new GamePanel(this);
    private GameWindow gameWindow ;
    private int FPS = 30;
    private int UPS = 200;
    private Player player;
    private LevelManager levelManager;
    public static final float SCALES = 2.0f;

    public static final int TILES_DEFAULT_SIZE = 32;
    public static final float TILES_SCALES = 1.5f;
    public static final int TILES_WIDTH=26;
    public static final int TILES_HEIGHT=14;
    public static final int TILES_SIZE = (int) (TILES_DEFAULT_SIZE *TILES_SCALES);
    public static final int GAME_WIDTH = TILES_SIZE * TILES_WIDTH;
    public static final int GAME_HEIGHT = TILES_SIZE * TILES_HEIGHT;



    Thread gameThread;
    public Game(){
        initClass();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        gameThread = new Thread(this::run);
        gameThread.run();
    }

    public void initClass(){
        this.player = new Player(10F, 10F, (int) ((int) 64 *SCALES), (int) (40*SCALES));
        this.levelManager = new LevelManager(this);
    }

    public void update(){
        player.update();
//        levelManager.update();
    }

    public void render(Graphics g){
        levelManager.draw(g);
        player.render(g);
        gamePanel.repaint();
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
            previusTime = current;

            if (deltaU >=1){
                this.update();
                UPStick++;
                deltaU--;
            }

            if (deltaF >=1){
                this.render(gamePanel.getGraphics());
                frame ++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000){
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS" + frame +"   ||   " + "UPS" +UPStick);
                frame =0;
                UPStick=0;
            }
        }
    }
    public void lostFocus(){
        player.reset();
    }
    public Player getPlayer(){
        return this.player;
    }
}
