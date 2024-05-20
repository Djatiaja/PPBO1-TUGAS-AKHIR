package Main;


import Input.KeyboardInput;
import Input.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import static utils.Constants.PlayerConstants.*;
import static utils.Constants.PlayerMovement.*;

public class GamePanel extends JPanel {
    private BufferedImage img;
    private BufferedImage[][] Animations;
    private int velocity = 3;
    private int aniTick, aniIndex, aniSpeed=36;
    private int player_action=IDLE;
    private int playerDir = -1;
    private boolean isPlayerMoving = false;
    private int player_x=0, player_y=0;

    public GamePanel(){
        addKeyListener(new KeyboardInput(this));
        addMouseListener(new MouseInput());
        addMouseListener(new MouseInput());
        setPanelSize();
        importImage();
        loadAnimation();
    }

    private void loadAnimation() {
        Animations = new BufferedImage[9][7];
        for( int j = 0; j < 9; j++ ){
            for (int i = 0; i < 6; i++) {
                Animations[j][i] = img.getSubimage(i*64, j*40, 64, 40);
            }
        }
    }

    private void importImage() {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(1280,800);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updatePlayerAction();
        updateAnimation();
        playerControl();
        g.drawImage(Animations[player_action][aniIndex], player_x, player_y,256,128,null);
    }

    private void updatePlayerAction() {
        if (isPlayerMoving){
            player_action = RUNNING;
        }else {
            player_action= IDLE;
        }
    }

    private void updateAnimation() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(player_action)){
                aniIndex =0;
            }
            aniTick=0;
        }
    }

    public void setPlayerDir(int playerDir){
        this.playerDir = playerDir;
        isPlayerMoving = true;
    }

    public void playerControl(){
        if (isPlayerMoving){
            switch (playerDir){
                case UP -> {
                    player_y -= velocity;
                }
                case LEFT -> {
                    player_x -= velocity;
                }
                case DOWN -> {
                    player_y += velocity;
                }
                case RIGHT -> {
                    player_x += velocity;
                }
            }
        }
    }
public void setAniIndex(int num){
        aniIndex=num;
}
    public void SetisPlayerMoving(boolean bool) {
        this.isPlayerMoving = bool;
    }
}
