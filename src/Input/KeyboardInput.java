package Input;
import Main.GamePanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static utils.Constants.PlayerMovement.*;

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
            gamePanel.setPlayerDir(UP);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_A){
            gamePanel.setPlayerDir(LEFT);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_S){
            gamePanel.setPlayerDir(DOWN);
        }

        if (e.getKeyCode() ==   KeyEvent.VK_D){
            gamePanel.setPlayerDir(RIGHT);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        gamePanel.SetisPlayerMoving(false);
        gamePanel.setAniIndex(0);

    }
}
