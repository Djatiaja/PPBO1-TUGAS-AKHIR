package Entity;
import Main.Game;
import utils.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static utils.Constants.PlayerConstants.*;
import static utils.LoadSave.playerAtlas;
import static utils.Helpers.canMoveHere;

public class Player  extends Entitty{
    private BufferedImage[][] Animations;
    private int velocity = 2;
    private int aniTick, aniIndex, aniSpeed=20;
    private int player_action=IDLE;
    private boolean kiri, kanan, atas, bawah;
    private int[][] levelData;
    private boolean isPlayerMoving = false, isAttacking=false;
    private int xOffset= (int) (22* Game.SCALES);
    private int yOffset = (int) (4* Game.SCALES);
    public Player(float x , float y, int width, int height, int[][] levelData) {
        super(x, y, width,height);
        this.levelData = levelData;
        loadAnimations();
        hitBox.width=20*Game.SCALES;
        hitBox.height=28*Game.SCALES;
    }
    public void reset(){
        kiri = false;
        kanan = false;
        atas = false;
        bawah = false;
        isPlayerMoving=false;
    }
    public void render(Graphics g, int xOfflevelset, int yOfflevelSet){
        g.drawImage(Animations[player_action][aniIndex], (int)hitBox.x - xOffset -xOfflevelset ,(int) hitBox.y -yOffset -yOfflevelSet,width,height,null);
        drawHitbox(g, xOfflevelset, yOfflevelSet);
    }

    public void update(){
        updatePos();
        updatePlayerAction();
        updateAnimation();
    }
public void updatePos(){
        isPlayerMoving=false;
//        System.out.printf(Arrays.toString(new boolean[]{kiri, kanan, atas, bawah}));
        if (!kiri&&!kanan&&!atas&&!bawah){
            return;
        }

        float xSpeed=0,ySpeed=0;

        if (kiri && !kanan){
            xSpeed-=velocity;
        } else if (!kiri && kanan) {
            xSpeed+=velocity;
        }

        if (atas && !bawah){
            ySpeed-=velocity;
        } else if (!atas && bawah) {
            ySpeed+=velocity;
        }

        if (canMoveHere(hitBox.x +xSpeed,hitBox.y+ySpeed,  hitBox.width,hitBox.height,levelData)){
            hitBox.y+=ySpeed;
            hitBox.x+=xSpeed;
            isPlayerMoving=true;
        }
}
    public void  loadAnimations() {
        BufferedImage img = LoadSave.getAtlasSprite(playerAtlas);
        Animations = new BufferedImage[9][7];
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 6; i++) {
                Animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }
    private void updatePlayerAction() {
        int startAni = player_action;
        if (isPlayerMoving){
            player_action = RUNNING;
        }else {
            player_action= IDLE;
        }
        if (isAttacking){
            this.player_action=ATTACK_1;
        }
        if (startAni != player_action){
            aniIndex=0;
            aniTick=0;
        }
    }

    private void updateAnimation() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(player_action) ){
                aniIndex =0;
                isAttacking=false;
            }
            aniTick=0;
        }

    }

    public void setAniIndex(int num){
        aniIndex=num;
    }
    public void SetisPlayerMoving(boolean bool) {
        this.isPlayerMoving = bool;
    }

    public boolean isKiri() {
        return kiri;
    }

    public void setKiri(boolean kiri) {
        this.kiri = kiri;
    }

    public boolean isKanan() {
        return kanan;
    }

    public void setKanan(boolean kanan) {
        this.kanan = kanan;
    }

    public boolean isAtas() {
        return atas;
    }

    public void setAtas(boolean atas) {
        this.atas = atas;
    }

    public boolean isBawah() {
        return bawah;
    }

    public void setBawah(boolean bawah) {
        this.bawah = bawah;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }
}
