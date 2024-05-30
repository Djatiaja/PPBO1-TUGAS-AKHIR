package Input;

import Main.GamePanel;

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
        if (e.getButton()==MouseEvent.BUTTON1){
            gamePanel.getGame().getPlayer().setAttacking(true);
            System.out.println("Atas "+gamePanel.getGame().getPlayer().isAtas());
            System.out.println("Bawah "+gamePanel.getGame().getPlayer().isBawah());
            System.out.println("Kiri "+gamePanel.getGame().getPlayer().isKiri());
            System.out.println("Kanan "+gamePanel.getGame().getPlayer().isKanan());

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
