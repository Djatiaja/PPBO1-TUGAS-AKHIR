package Main;

import Entity.Player;
import Levels.LevelManager;

import java.awt.*;

public class Game implements  Runnable{
    private GamePanel gamePanel = new GamePanel(this);
    private GameWindow gameWindow ;
    private int FPS = 30;
    private int UPS = 200;
    private Player player;
    private static LevelManager levelManager;
    private int maXXOfflevelSet;
    private int maxYOfflevelSet;
    private int maxHeightGame;





    public static final float SCALES = 2.0f;
    public static final int TILES_DEFAULT_SIZE = 32;
    public static final float TILES_SCALES = 1.5f;
    public static final int TILES_WIDTH=26;
    public static final int TILES_HEIGHT=14;
    public static final int TILES_SIZE = (int) (TILES_DEFAULT_SIZE *TILES_SCALES);
    public static final int GAME_WIDTH = TILES_SIZE * TILES_WIDTH;
    public static final int GAME_HEIGHT = TILES_SIZE * TILES_HEIGHT;
    public static int maxWidthGame ;
    private static float xOfflevelset;
    private static float yOfflevelset;

    private float leftBorder ;
    private float rightBorder;
    private float topBorder ;
    private float bottomBorder;





    Thread gameThread;
    public Game(){
        initClass();
        setBorder();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        gameThread = new Thread(this::run);
        gameThread.run();
    }

    public void initClass(){
        this.levelManager = new LevelManager(this);
        this.player = new Player(levelManager.getCurrentSpawn()[1] * TILES_SIZE, levelManager.getCurrentSpawn()[0] * TILES_SIZE, (int) ((int) 64 *SCALES), (int) (40*SCALES), levelManager.getCurrentLevel());
    }

    public void update(){
        player.update();
        checkBorder();
//        levelManager.update();
    }

    private void checkBorder() {
        float diff = player.getHitBox().x - xOfflevelset;
        float ydiff = player.getHitBox().y - yOfflevelset;

        if (diff > rightBorder){
            xOfflevelset+= diff - rightBorder;
        } else if (diff < leftBorder) {
            xOfflevelset += diff - leftBorder;
        }

        if (xOfflevelset >= maXXOfflevelSet){
            xOfflevelset = maXXOfflevelSet;
        }else if (xOfflevelset <= 0){
            xOfflevelset=0;
        }


        if (ydiff>=bottomBorder){
            yOfflevelset += ydiff - bottomBorder;
        } else if (ydiff <= topBorder) {
            yOfflevelset += ydiff - topBorder;
        }

        if (yOfflevelset > maxYOfflevelSet){
            yOfflevelset = maxYOfflevelSet;
        } else if (yOfflevelset <= 0) {
            yOfflevelset = 0;
        }

    }

    public void render(Graphics g){
        levelManager.draw(g, (int) xOfflevelset, (int) yOfflevelset);
        player.render(g, (int) xOfflevelset, (int) yOfflevelset);
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
    public  void setBorder(){
        maxWidthGame =  (levelManager.getCurrentLevel()[0].length * TILES_SIZE );
        maxHeightGame =  (levelManager.getCurrentLevel().length * TILES_SIZE );
        xOfflevelset =0;
        yOfflevelset=0;
        leftBorder = (float) (0.2 * GAME_WIDTH);
        rightBorder = (float) (0.8 * GAME_WIDTH);
        maXXOfflevelSet = maxWidthGame -GAME_WIDTH ;

        maxYOfflevelSet = maxHeightGame - GAME_HEIGHT;
        topBorder = (float) (0.2 * GAME_HEIGHT);
        bottomBorder = (float) (0.8 * GAME_HEIGHT);

    }
    public void lostFocus(){
        player.reset();
    }
    public Player getPlayer(){
        return this.player;
    }
}
