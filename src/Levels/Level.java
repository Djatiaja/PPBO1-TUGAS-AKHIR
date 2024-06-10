package Levels;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Level {
    private int[][] levelData;
    private int[] spawnCord;
    private ArrayList<int[][]> levelDataList = new ArrayList<>();
    BufferedImage[] levelSprite;
    public Level( int[] spawnCord , BufferedImage[] levelSprite){
//        printDatainINT();
        this.spawnCord = spawnCord;
        this.levelSprite = levelSprite;
    }
    public int getSpriteIndex(int[][] levelData,int x, int y){
        return levelData[x][y];
    }

    public void addLevelData(int[][] levelData){
        levelDataList.add(levelData);
    }
    public void printDatainINT(){
//Debugging
        for (int i = 0; i < levelData.length; i++) {
            String data = "";
            System.out.println(Arrays.toString(levelData[i]));
        }
    }

    public void printLevelData(){
        for (int[][] levelData:levelDataList) {
            for (int i = 0; i < levelData.length; i++) {
                String data = "";
                System.out.println(Arrays.toString(levelData[i]));
            }
        }
    }

    public ArrayList<int[][]> getLevelDataList() {
        return levelDataList;
    }

    public int[] getSpawnCord() {
        return spawnCord;
    }

    public int[][] getLevelData(){
        return levelData;
    }

    public int[][] getCurrentLevelData() {
        return levelData;
    }
}
