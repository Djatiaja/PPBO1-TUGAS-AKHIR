package Entity;

import java.awt.*;

public abstract class Entitty {
    protected float x, y;
    protected int width, height;
    protected Rectangle hitBox;
    public Entitty(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height= height;
        this.width = width;
        setHitBox((int) x, (int) y,width,height);
    }

    public void setHitBox(int x, int y,int width,int height){
        this.hitBox = new Rectangle();
        this.hitBox.height=height;
        this.hitBox.width = width;
        this.hitBox.y =y;
        this.hitBox.x =x;
    }

    public void drawHitbox(Graphics g){
        g.setColor(Color.red);
        g.drawRect(hitBox.x,hitBox.y,hitBox.width, hitBox.height);
    }
    public void updateHitbox(){
        this.hitBox.y = (int) y;
        this.hitBox.x = (int) x;
    }
}
