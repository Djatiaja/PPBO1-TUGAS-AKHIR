package utils;

import Main.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static final String playerAtlas="/res/player_sprites.png";
    public static final String levelAtlas="/res/outside_sprites.png";
    public static final String level_one_data="/res/level_one_data.png";

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
        int[][] levelData = new int[Game.TILES_HEIGHT][Game.TILES_WIDTH];
        BufferedImage img = getAtlasSprite(level_one_data);
        for (int i = 0; i < Game.TILES_HEIGHT; i++) {
            for (int j = 0; j < Game.TILES_WIDTH; j++) {
                Color color = new Color(img.getRGB(j,i));
                int value = color.getRed();
                if (value >=48){
                    value=0;
                }
                levelData[i][j] = value;

            }
            
        }
        return levelData;
    }
}
