package Levels;

import Main.Game;
import utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;
import static utils.LoadSave.levelAtlas;
import static utils.LoadSave.level_one_data;

public class LevelManager {
    private Game game;
    private BufferedImage levelSprite[];
    private Level levelOne;
    public LevelManager(Game game){
        this.game = game;
        loadLevelSprite();
        levelOne = new Level(LoadSave.getLevelData());
    }

    public void loadLevelSprite(){
        levelSprite = new BufferedImage[48];
        BufferedImage img = LoadSave.getAtlasSprite(levelAtlas);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 12; j++) {
                int index = i * 12 +j;
                levelSprite[index] = img.getSubimage(j*32,i*32,32,32);
            }

        }
    }


    public void draw(Graphics g){
        for (int i = 0; i < Game.TILES_HEIGHT; i++) {
            for (int j = 0; j < Game.TILES_WIDTH; j++) {
                int index = levelOne.getSpriteIndex(i,j);
                g.drawImage(levelSprite[index], Game.TILES_SIZE*j,Game.TILES_SIZE *i,Game.TILES_SIZE,Game.TILES_SIZE,null);
            }
        }

    }
    public void update(){
    }
}
