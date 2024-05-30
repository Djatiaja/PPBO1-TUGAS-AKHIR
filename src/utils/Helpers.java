package utils;

import Main.Game;

public class Helpers {


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
        if (value <= 48 && value!=11){
            return false;
        }
        return false;
    }
}
