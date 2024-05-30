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
        levelOne = new Level(LoadSave.getLevelData(), LoadSave.getSpawnCord());
    }

    public void loadLevelSprite(){
        levelSprite = new BufferedImage[18*27];
        BufferedImage img = LoadSave.getAtlasSprite(levelAtlas);
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 27; j++) {
                int index = i * 27 +j;
                levelSprite[index] = img.getSubimage(j*16,i*16,16,16);
            }

        }
    }


    public void draw(Graphics g, int xOfflevelset, int yOfflevelSet){
        for (int i = 0; i <getCurrentLevel().length; i++) {
            for (int j = 0; j < getCurrentLevel()[0].length; j++) {
                int index = levelOne.getSpriteIndex(i,j);
                g.drawImage(levelSprite[index], Game.TILES_SIZE*j - xOfflevelset,Game.TILES_SIZE *i -yOfflevelSet,Game.TILES_SIZE,Game.TILES_SIZE,null);
            }
        }

    }
    public void update(){
    }

    public int[][] getCurrentLevel(){
        return levelOne.getLevelData();
    }
    public int[] getCurrentSpawn(){
        return levelOne.getSpawnCord();
    }

    public Level getLevel() {
        return levelOne;
    }
}
