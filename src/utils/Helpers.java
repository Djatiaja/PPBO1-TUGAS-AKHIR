package utils;

import Main.Game;

import java.util.Arrays;

public class Helpers {
    public static boolean devMode=false;
    public static void setDevMode(Boolean bool){
        devMode=bool;
    }
    public static boolean canMoveHere(float x, float y, float width,float height, int[][] levelData){
        if (!isSolid(x,y,levelData)){
            if (!isSolid(x+width,y+height, levelData)){
                if (!isSolid(x,y+height,levelData)){
                    if (!isSolid(x+width,y,levelData)){
                        return true;
                    };
                };
            };
        };


        return false;
    }

    public static boolean isSolid(float x, float y, int[][] levelData){
        int maxWidth = levelData[0].length * Game.TILES_SIZE;
        int maxHeight = levelData.length* Game.TILES_SIZE;
        if (x<=0 || x>= maxWidth){
            return true;
        }
        if (y <=0 || y>= maxHeight){
            return true;
        }
        float xIndex = x/Game.TILES_SIZE;
        float yIndex = y/Game.TILES_SIZE;
        int value = levelData[(int) yIndex][(int) xIndex];
        Integer notSoidSprite[]  = {9,63,41,37,36,35,44,13,41,45,9,409,28,63,405,432,8,459,40,64,14,10,434,435,436,62};
//        System.out.println(Arrays.asList(notSoidSprite).contains(value));
        if (Arrays.asList(notSoidSprite).contains(value)){
            return false;
        }
        return !devMode;
    }
}
