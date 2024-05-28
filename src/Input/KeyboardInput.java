package Input;
import Main.GamePanel;
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
        if (e.getKeyCode() ==   KeyEvent.VK_W){
            gamePanel.getGame().getPlayer().setAtas(true);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().setKiri(true);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_S){
            gamePanel.getGame().getPlayer().setBawah(true);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().setKanan(true);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() ==   KeyEvent.VK_W){
            gamePanel.getGame().getPlayer().setAtas(false);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_A){
            gamePanel.getGame().getPlayer().setKiri(false);

        }

        if (e.getKeyCode() ==   KeyEvent.VK_S){
            gamePanel.getGame().getPlayer().setBawah(false);

        }

        if (e.getKeyCode() ==   KeyEvent.VK_D){
            gamePanel.getGame().getPlayer().setKanan(false);
        }
        gamePanel.getGame().getPlayer().SetisPlayerMoving(false);
        gamePanel.getGame().getPlayer().setAniIndex(0);

    }
}
