package Gamestate;

import Main.Game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu extends State implements StateMethod{
    public Menu(Game game) {
        super(game);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Menu", Game.GAME_HEIGHT/2, 200);
    }

    @Override
    public void update() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
