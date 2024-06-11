package Levels;
import Gamestate.Playing;
import Main.Game;
import utils.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import static utils.LoadSave.getMapdata;
import static utils.LoadSave.levelAtlasCity;

public class LevelManager {
    private Game game;
    private BufferedImage levelSpriteCity[];
    private Level currentLevel;
    private Level city;
    private Level home;
    private Level office;
    private Level debugingLevel;
    private Playing playing;

    public static final int CITY=1;
    public static final int DEBUGGING=2;

    public LevelManager(Game game, Playing playing){
        this.game = game;
        this.playing = playing;
        levelSpriteCity=loadLevelSprite( levelAtlasCity, new int[]{18, 27});
        debugingLevel = new Level( new int[]{11,0}, levelSpriteCity);
        System.out.println(Arrays.toString(getMapdata()));
        debugingLevel.addLevelData(LoadSave.getMapdata());
        city = new Level( new int[]{11,0}, levelSpriteCity);
        city.addLevelData(LoadSave.getLevelData(LoadSave.CITY_Base));
        city.addLevelData(LoadSave.getLevelData(LoadSave.CITY_Decoration));
        this.currentLevel = city;
        city.printLevelData();
    }

    public BufferedImage[] loadLevelSprite(String path, int[]scale){
        BufferedImage[] levelSprite= new BufferedImage[scale[0]*scale[1]];
        BufferedImage img = LoadSave.getAtlasSprite(path);
        for (int i = 0; i < scale[0]; i++) {
            for (int j = 0; j < scale[1]; j++) {
                int index = i * scale[1] +j;
                levelSprite[index] = img.getSubimage(j*16,i*16,16,16);
            }
        }

        return levelSprite;
    }

    public void draw(Graphics g, int xOfflevelset, int yOfflevelSet){
        for (int[][] leveldata:this.currentLevel.getLevelDataList()) {
            for (int i = 0; i <leveldata.length; i++) {
                for (int j = 0; j < leveldata[0].length; j++) {
                    int index = leveldata[i][j];
                    if (index < 0) continue;
                    g.drawImage(this.currentLevel.levelSprite[index], Game.TILES_SIZE*j - xOfflevelset,Game.TILES_SIZE *i -yOfflevelSet,Game.TILES_SIZE,Game.TILES_SIZE,null);
                }
            }
        }


    }
    public void update(){    }

    public int[][] getCurrentLevelData(){
        return currentLevel.getLevelData();
    }
    public int[] getCurrentSpawn(){
        return currentLevel.getSpawnCord();
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevelint) {
        switch (currentLevelint){
            case DEBUGGING:{
                this.currentLevel =debugingLevel;
                this.playing.getPlayer().setLevelData(currentLevel.getLevelDataList());
                this.playing.getPlayer().resetPlayerPos(this.currentLevel.getSpawnCord());
                this.playing.resetMaxXYOffset(this.currentLevel);
                break;
            }
            case CITY:{
                this.currentLevel = city;
                this.playing.getPlayer().setLevelData(currentLevel.getLevelDataList());
                this.playing.getPlayer().resetPlayerPos(this.currentLevel.getSpawnCord());
                this.playing.resetMaxXYOffset(this.currentLevel);
                break;
            }

        }


    }
}
