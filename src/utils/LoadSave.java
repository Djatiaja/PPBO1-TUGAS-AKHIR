package utils;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static final String playerAtlas="/res/player_sprites.png";
    public static final String levelAtlas="/res/tilemap_packed.png";
    public static final String level_one_data="/res/City_map_noFix13.png";


    private static int[] spawnCord;

    public static BufferedImage getAtlasSprite(String path) {
        InputStream is = LoadSave.class.getResourceAsStream(path);
        BufferedImage img;
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {try {
            is.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }}
        return img;
    }

    public static int[][] getLevelData(){
        BufferedImage img = getAtlasSprite(level_one_data);
        int[][] levelData = new int[img.getHeight()][img.getWidth()];
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j,i));
                int value = color.getRed();
                int valuePlus = color.getGreen();
                if (valuePlus==1){
                    value += 255;
                }
                levelData[i][j] = value;
            }
            
        }
        return levelData;
    }

    public static int[] getSpawnCord(){
        BufferedImage img = getAtlasSprite(level_one_data);
        int[] spawnCord = {0,0};
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color color = new Color(img.getRGB(j    ,i));
                int valueSpawn = color.getBlue();
                if (valueSpawn==255){
                    spawnCord[0]=i;
                    spawnCord[1]=j;
                    break;
                }
            }
        }
        return spawnCord;
    }

}
