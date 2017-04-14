package sample;

/**
 * Created by ChiChaChai on 30/3/2560.
 */


import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import sun.java2d.Surface;

import java.util.*;
import java.io.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class SaveMap {

    private int widthBlock;
    private int heightBlock;
    private double widthResolution;
    private double heightResolution;
    private static double widthEachSprite;
    private static double heightEachSprite;

    public static MapObj[][] mapObj;
    public static MapObj[][] mapItem;
    public static MapObj[][] mapBG;
    private int rateDropItem = 15;
    private Random rand = new Random(System.currentTimeMillis());

    public char[][] myArray = new char[15][15];

    public SaveMap(int widthBlock, int heightBlock, double widthResolution, double heightResolution) {
        this.widthBlock = widthBlock;
        this.heightBlock = heightBlock;
        this.widthResolution = widthResolution;
        this.heightResolution = heightResolution;
        widthEachSprite = widthResolution / widthBlock;
        heightEachSprite = heightResolution / heightBlock;
        mapObj = new MapObj[heightBlock][widthBlock];
        mapItem = new MapObj[heightBlock][widthBlock];
        mapBG = new MapObj[heightBlock][widthBlock];
        readMap();
        init();

    }

    public ImageView getMapObjCore(int i, int j) {
        return mapObj[i][j].getItemCore();
    }

    public static double getWidthEachSprite() {
        return widthEachSprite;
    }

    public static double getHeightEachSprite() {
        return heightEachSprite;
    }

    private void init() {


        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                mapBG[i][j] = new MapObj(SourceDir.GROUND, false);
                mapBG[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapBG[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapBG[i][j].getItemCore().setX(widthEachSprite * j);
                mapBG[i][j].getItemCore().setY(heightEachSprite * i);
            }

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {

                if (myArray[i][j] == '#') {
                    mapObj[i][j] = new MapObj(SourceDir.COWALL, false);
                } else if (myArray[i][j] == 's') {
                    mapObj[i][j] = new MapObj(false);
                } else if (myArray[i][j] == 'o') {
                    mapObj[i][j] = new MapObj(SourceDir.T, false);
                } else if (myArray[i][j] == 'i') {
                    mapObj[i][j] = new MapObj(SourceDir.B, false);
                } else if (myArray[i][j] == '5') {
                    mapObj[i][j] = new MapObj(SourceDir.ROWALL, false);
                } else if (myArray[i][j] == 't') {
                    mapObj[i][j] = new MapObj(SourceDir.TL, false);
                } else if (myArray[i][j] == 'b') {
                    mapObj[i][j] = new MapObj(SourceDir.TR, false);
                } else if (myArray[i][j] == 'j') {
                    mapObj[i][j] = new MapObj(SourceDir.BL, false);
                } else if (myArray[i][j] == 'h') {
                    mapObj[i][j] = new MapObj(SourceDir.BR, false);
                } else if (myArray[i][j] == 'm') {
                    mapObj[i][j] = new MapObj(SourceDir.LC, false);
                } else if (myArray[i][j] == 'n') {
                    mapObj[i][j] = new MapObj(SourceDir.RC, false);
                } else if (myArray[i][j] == 'l') {
                    mapObj[i][j] = new MapObj(SourceDir.LAMP, false);
                } else if (myArray[i][j] == '7') {
                    mapObj[i][j] = new MapObj(SourceDir.SAKURA, false);
                } else if (myArray[i][j] == 'r') {
                    mapObj[i][j] = new MapObj(SourceDir.ROCK, false);
                } else if (myArray[i][j] == 'w') {
                    mapObj[i][j] = new MapObj(SourceDir.SNOWT, false);
                } else if (myArray[i][j] == '8') {
                    mapObj[i][j] = new MapObj(SourceDir.TREE, false);
                } else if (myArray[i][j] == '9') {
                    mapObj[i][j] = new MapObj(SourceDir.TREE2, false);
                } else {
                    mapObj[i][j] = new MapObj(false);
                }


                mapObj[i][j].getItemCore().setFitWidth(widthEachSprite);
                mapObj[i][j].getItemCore().setFitHeight(heightEachSprite);
                mapObj[i][j].getItemCore().setX(widthEachSprite * j);
                mapObj[i][j].getItemCore().setY(heightEachSprite * i);

            }

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++) {
                if (rand.nextInt(100) < rateDropItem) {
                    switch (rand.nextInt(4)) {
                        case 0:
                            mapItem[i][j] = new MapObj(SourceDir.AMOUNT_BOMB_ITEM, true);
                            break;
                        case 1:
                            mapItem[i][j] = new MapObj(SourceDir.FAST_ITEM, true);
                            break;
                        case 2:
                            mapItem[i][j] = new MapObj(SourceDir.POTION_ITEM, true);
                            break;
                        case 3:
                            mapItem[i][j] = new MapObj(SourceDir.SHIELD_ITEM, true);
                            break;
                    }


                } else {
                    mapItem[i][j] = new MapObj(true);
                }

                mapItem[i][j].getItemCore().setX(widthEachSprite * j);
                mapItem[i][j].getItemCore().setY(heightEachSprite * i);
                mapItem[i][j].setVisible(false);
            }
    }

    public void addItem(Pane pane) {

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapBG[i][j].getItemCore());

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapObj[i][j].getItemCore());

        for (int i = 0; i < heightBlock; i++)
            for (int j = 0; j < widthBlock; j++)
                pane.getChildren().add(mapItem[i][j].getItemCore());

    }

    public void save() {

        try {

            FileOutputStream saveFile = new FileOutputStream("SaveObj.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(mapObj);
            save.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }


    }

    public void readMap() {


        try {
            Scanner scanner = new Scanner(new File("SaveObj.txt"));
            for (int row = 0; scanner.hasNextLine() && row < 15; row++) {
                char[] chars = scanner.nextLine().toCharArray();
                for (int i = 0; i < 15 && i < chars.length; i++) {
                    myArray[row][i] = chars[i];
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
