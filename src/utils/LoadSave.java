package utils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class LoadSave {
    public static final String playerAtlas="/res/player_sprites.png";
    public static final  String debuggingAtlas ="/res/tilemap_packed.png";
    public static final String levelAtlasCity="/res/tilemap_packed.png";
    public static final String CITY_Base="src/res/City_Base.csv";
    public static final String CITY_Decoration="src/res/City_Decoration.csv";
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

    public static int[][] getLevelData(String path){

        BufferedReader reader;
        int[][] levelData = new int[40][40];
        try {
            reader = new BufferedReader(new FileReader(path));
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null){
                String[] tokens = line.split(",");
                for (int i = 0; i < tokens.length; i++) {
                    levelData[row][i] = Integer.parseInt(tokens[i]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return levelData;
    }


    public static int[][] getMapdata(){

        int[][] levelData = new int[40][27];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 27; j++) {
                levelData[i][j] = i*27 + j;
            }
        }
        System.out.println(Arrays.toString(levelData[0]));
        return levelData;

    }

}
