package Main;


import Input.KeyboardInput;
import Input.MouseInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game){
        addKeyListener(new KeyboardInput(this));
        this.game = game;
        addMouseListener(new MouseInput(this));
        setPanelSize();
    }

    private void setPanelSize() {
        Dimension dimension = new Dimension(GAME_WIDTH,GAME_HEIGHT);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        System.out.println(GAME_WIDTH);
        System.out.println(GAME_HEIGHT);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }
    public Game getGame(){
        return this.game;
    }
    }
