package Levels;

import utils.LoadSave;

import java.awt.datatransfer.FlavorEvent;
import java.util.Arrays;

public class Level {
    private int[][] levelData;
    private int[] spawnCord;
    public Level(int[][] levelData, int[] spawnCord ){
        this.levelData = levelData;
        printDatainINT();
        this.spawnCord = spawnCord;
    }
    public int getSpriteIndex(int x, int y){
        return levelData[x][y];
    }

    public void printDatainINT(){
//Debugging
        for (int i = 0; i < levelData.length; i++) {
            String data = "";
//            for (int j = 0; j < levelData[0].length; j++) {
//                int temp = levelData[i][j];
//                data += temp+" ";
//            }
            System.out.println(Arrays.toString(levelData[i]));

        }
    }

    public int[] getSpawnCord() {
        return spawnCord;
    }

    public int[][] getLevelData(){
        return levelData;
    }
}
