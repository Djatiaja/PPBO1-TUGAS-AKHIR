package Levels;

import utils.LoadSave;

import java.awt.datatransfer.FlavorEvent;
import java.util.Arrays;

public class Level {
    private int[][] levelData;
    public Level(int[][] levelData ){
        this.levelData = levelData;
//        printDatainINT();
    }
    public int getSpriteIndex(int x, int y){
        return levelData[x][y];
    }

    public void printDatainINT(){
//Debugging
        for (int i = 0; i < levelData.length; i++) {
            String data = "";
            for (int j = 0; j < levelData[0].length; j++) {
                int temp = levelData[i][j];
                data += temp+" ";
            }
            System.out.println(data);

        }
    }
}
